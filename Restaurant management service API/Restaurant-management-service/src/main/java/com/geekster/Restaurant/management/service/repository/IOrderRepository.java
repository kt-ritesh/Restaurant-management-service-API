package com.geekster.Restaurant.management.service.repository;

import com.geekster.Restaurant.management.service.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderFood ,Long> {
}
