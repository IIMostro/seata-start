## 基于seata的一个分布式事务实现
seata需要创建的表格
-- auto-generated definition
create table branch_table
(
    branch_id         bigint        not null
        primary key,
    xid               varchar(128)  not null,
    transaction_id    bigint        null,
    resource_group_id varchar(32)   null,
    resource_id       varchar(256)  null,
    branch_type       varchar(8)    null,
    status            tinyint       null,
    client_id         varchar(64)   null,
    application_data  varchar(2000) null,
    gmt_create        datetime      null,
    gmt_modified      datetime      null
);

create index idx_xid
    on branch_table (xid);

-- auto-generated definition
create table global_table
(
    xid                       varchar(128)  not null
        primary key,
    transaction_id            bigint        null,
    status                    tinyint       not null,
    application_id            varchar(32)   null,
    transaction_service_group varchar(32)   null,
    transaction_name          varchar(128)  null,
    timeout                   int           null,
    begin_time                bigint        null,
    application_data          varchar(2000) null,
    gmt_create                datetime      null,
    gmt_modified              datetime      null
);

create index idx_gmt_modified_status
    on global_table (gmt_modified, status);

create index idx_transaction_id
    on global_table (transaction_id);

-- auto-generated definition
create table lock_table
(
    row_key        varchar(128) not null
        primary key,
    xid            varchar(96)  null,
    transaction_id bigint       null,
    branch_id      bigint       not null,
    resource_id    varchar(256) null,
    table_name     varchar(32)  null,
    pk             varchar(36)  null,
    gmt_create     datetime     null,
    gmt_modified   datetime     null
);

create index idx_branch_id
    on lock_table (branch_id);


业务库需要创建的表格
-- auto-generated definition
create table undo_log
(
    id            bigint auto_increment
        primary key,
    branch_id     bigint       not null,
    xid           varchar(100) not null,
    context       varchar(128) not null,
    rollback_info longblob     not null,
    log_status    int          not null,
    log_created   datetime     not null,
    log_modified  datetime     not null,
    ext           varchar(100) null,
    constraint ux_undo_log
        unique (xid, branch_id)
);

