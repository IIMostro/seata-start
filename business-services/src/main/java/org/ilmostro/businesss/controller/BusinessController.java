package org.ilmostro.businesss.controller;

import org.ilmostro.businesss.service.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IlMostro
 * @date 2020/7/4 9:02 上午
 */
@RestController
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @GetMapping("/purchase")
    public void purchase(Integer user, String code, Integer count){
        service.purchase(user, code, count);
    }
}
