package org.ilmostro.order.controller;

import org.ilmostro.order.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author IlMostro
 * @date 2020/7/3 11:07 上午
 */
@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public void create(@RequestParam("user") Integer user,
                       @RequestParam("code") String code,
                       @RequestParam("count")Integer count){
        service.create(user, code, count);
    }
}
