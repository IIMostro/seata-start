package org.ilmostro.account.repository;

import org.ilmostro.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author IlMostro
 * @date 2020/7/2 12:07 上午
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUser(Integer user);
}
