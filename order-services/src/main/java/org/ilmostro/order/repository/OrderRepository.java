package org.ilmostro.order.repository;

import org.ilmostro.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author IlMostro
 * @date 2020/7/3 10:49 上午
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
