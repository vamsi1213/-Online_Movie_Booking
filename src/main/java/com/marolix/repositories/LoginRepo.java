package com.marolix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{
	
	Login findByUserId(String userId);

}
