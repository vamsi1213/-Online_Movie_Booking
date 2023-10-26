package com.marolix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marolix.entity.Theatre;

@Repository

public interface TheatreRepo extends JpaRepository<Theatre, Integer>{

	Theatre findByTheatreId(int id);
}
