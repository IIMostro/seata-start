package org.ilmostro.storage.service;

import org.ilmostro.storage.entity.Storage;
import org.ilmostro.storage.repository.StorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author IlMostro
 * @date 2020/7/3 12:49 下午
 */
@Service
public class StorageService {

    private final StorageRepository repository;

    public StorageService(StorageRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deduct(String code, Integer count){

        Storage storage = repository.findByCode(code);
        storage.setCount(storage.getCount() - count);
        repository.save(storage);
    }
}
