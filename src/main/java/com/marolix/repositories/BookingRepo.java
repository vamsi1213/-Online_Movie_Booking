package com.marolix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.entity.Booking;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
	
	List<Booking> findAllByUserId(String userId);

}
