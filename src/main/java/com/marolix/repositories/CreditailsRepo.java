package com.marolix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.entity.Creditials;


public interface CreditailsRepo extends JpaRepository<Creditials,Integer> {

	Creditials findByUsername(String username);
}
