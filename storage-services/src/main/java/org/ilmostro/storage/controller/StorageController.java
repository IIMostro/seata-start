package org.ilmostro.storage.controller;

import org.ilmostro.storage.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IlMostro
 * @date 2020/7/3 12:51 下午
 */
@RestController
public class StorageController {

    private final StorageService service;

    public StorageController(StorageService service) {
        this.service = service;
    }

    @GetMapping("/deduct")
    public void deduct(String code, Integer count){
        service.deduct(code, count);
    }

}
