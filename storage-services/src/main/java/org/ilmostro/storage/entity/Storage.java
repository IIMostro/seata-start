package org.ilmostro.storage.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author IlMostro
 * @date 2020/7/3 12:47 下午
 */
@Entity
@Table(name = "storage_tbl")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
public class Storage {

    @Id
    private Long id;
    private String code;
    private Integer count;
}
