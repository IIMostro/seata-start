package org.ilmostro.account.controller;

import org.ilmostro.account.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author IlMostro
 * @date 2020/7/2 12:22 上午
 */
@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/deduct")
    public void deduct(Integer user, BigDecimal money){
        service.deduct(user, money);
    }
}
