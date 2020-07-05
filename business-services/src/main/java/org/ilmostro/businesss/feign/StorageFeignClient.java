package org.ilmostro.businesss.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author IlMostro
 * @date 2020/7/3 10:28 下午
 */
@FeignClient(name = "storage-service", url = "127.0.0.1:8082")
public interface StorageFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("code") String code,@RequestParam("count") Integer count);
}
