package org.ilmostro.storage.repository;

import org.ilmostro.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author IlMostro
 * @date 2020/7/3 12:48 下午
 */
public interface StorageRepository extends JpaRepository<Storage, Long> {
    Storage findByCode(String code);
}
