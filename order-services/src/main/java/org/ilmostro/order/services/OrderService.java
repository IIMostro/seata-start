package org.ilmostro.order.services;

import org.ilmostro.order.entity.Order;
import org.ilmostro.order.feign.AccountFeignClient;
import org.ilmostro.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author IlMostro
 * @date 2020/7/3 11:03 上午
 */
@Service
public class OrderService {

    private final AccountFeignClient feign;
    private final OrderRepository repository;

    public OrderService(AccountFeignClient feign,
                        OrderRepository repository) {
        this.feign = feign;
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(Integer user, String code, Integer count){

        BigDecimal orderMoney = BigDecimal.valueOf(count).multiply(BigDecimal.TEN);

        Order order = new Order();
        order.setUserId(user);
        order.setCommodityCode(code);
        order.setCount(count);
        order.setMoney(orderMoney);
        repository.save(order);

        feign.deduct(user, orderMoney);
    }
}
