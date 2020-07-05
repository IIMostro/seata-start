package org.ilmostro.account.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author IlMostro
 * @date 2020/7/2 12:04 上午
 */
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "account_tbl")
public class Account {

    @Id
    private Integer id;
    private Integer user;
    private BigDecimal balance;
}
