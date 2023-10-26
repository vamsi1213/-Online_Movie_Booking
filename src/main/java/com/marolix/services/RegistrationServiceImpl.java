package com.marolix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.entity.RegistrationPage;
import com.marolix.repositories.RegistrationPageRepo;


@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationPageRepo regRepo;
	
	@Override
	public RegistrationPage save(RegistrationPage reg) {
		// TODO Auto-generated method stub
		return regRepo.save(reg);
	}

	@Override
	public RegistrationPage findById(Integer id) {
		// TODO Auto-generated method stub
		return regRepo.findById(id).get();
	}

	@Override
	public RegistrationPage update(RegistrationPage reg) {
		// TODO Auto-generated method stub
		return regRepo.save(reg);
	}

	@Override
	public void deleteById(Integer id) {

		regRepo.deleteById(id);
	}

	@Override
	public List<RegistrationPage> findAll() {
		List<RegistrationPage> list = new ArrayList<RegistrationPage>();
		regRepo.findAll().forEach(reg -> list.add(reg));
		return list;
	}

}
