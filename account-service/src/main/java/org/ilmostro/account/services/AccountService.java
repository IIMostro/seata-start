package org.ilmostro.account.services;

import org.ilmostro.account.entity.Account;
import org.ilmostro.account.repository.AccountRepository;
import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author IlMostro
 * @date 2020/7/2 12:18 上午
 */
@Service
public class AccountService {

    private static final int ERROR = 1002;

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deduct(Integer user, BigDecimal money){
        Account account = repository.findAccountByUser(user);
        account.setBalance(account.getBalance().subtract(money));
        repository.save(account);
        if(ERROR == user){
            throw new RuntimeException();
        }
    }
}
