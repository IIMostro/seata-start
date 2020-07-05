package org.ilmostro.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author IlMostro
 * @date 2020/7/3 10:55 上午
 */
@FeignClient(name = "account-service", url = "127.0.0.1:8080")
public interface AccountFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("user") Integer user
            ,@RequestParam("money") BigDecimal money);
}
