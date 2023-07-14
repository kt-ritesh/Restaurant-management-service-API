package com.geekster.Restaurant.management.service.repository;

import com.geekster.Restaurant.management.service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant , Long> {
}
