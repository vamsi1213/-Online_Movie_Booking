package com.marolix.services;

import java.util.List;

import com.marolix.entity.RegistrationPage;

public interface RegistrationService {
	
	public RegistrationPage save(RegistrationPage reg);
	
	public RegistrationPage findById(Integer id);
	
	public RegistrationPage update(RegistrationPage reg);
	
	public void deleteById(Integer id);
	
	public List<RegistrationPage> findAll();
}
