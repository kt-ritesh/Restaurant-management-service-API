package com.geekster.Restaurant.management.service.repository;

import com.geekster.Restaurant.management.service.model.Costumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostumberRepository extends JpaRepository<Costumber , Long> {

    Costumber findFirstByCostumberEmailId(String userEmailId);
}
