package org.ilmostro.businesss.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.ilmostro.businesss.feign.OrderFeignClient;
import org.ilmostro.businesss.feign.StorageFeignClient;
import org.springframework.stereotype.Service;

/**
 * @author IlMostro
 * @date 2020/7/3 10:28 下午
 */
@Service
public class BusinessService {

    private final StorageFeignClient storageFeignClient;
    private final OrderFeignClient orderFeignClient;

    public BusinessService(StorageFeignClient storageFeignClient,
                           OrderFeignClient orderFeignClient) {
        this.storageFeignClient = storageFeignClient;
        this.orderFeignClient = orderFeignClient;
    }

    @GlobalTransactional
    public void purchase(Integer user, String code, Integer count){
        storageFeignClient.deduct(code, count);
        orderFeignClient.create(user, code, count);
    }
}
