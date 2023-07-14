package com.geekster.Restaurant.management.service.repository;

import com.geekster.Restaurant.management.service.model.Authentication;
import com.geekster.Restaurant.management.service.model.Costumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<Authentication , Long> {
    Authentication findByCostumber(Costumber costumberObj);

    Authentication findFirstByAuthenticationToken(String token);
}
