package com.marolix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.entity.Theatre;
import com.marolix.repositories.TheatreRepo;

@Service
public class TheatreServiceImpl implements TheatreService{

	@Autowired
	private MovieListServiceImpl movieService;
	
	@Autowired
	private TheatreRepo theatreRepo;
	
	@Override
	public List<Theatre> TheatreList() {
		// TODO Auto-generated method stub
		return theatreRepo.findAll();
	}

	@Override
	public Theatre saveTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return theatreRepo.save(theatre);
	}

	@Override
	public Theatre findByTheatreId(int id) {
		// TODO Auto-generated method stub
		return theatreRepo.findByTheatreId(id);
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return theatreRepo.save(theatre);
	}

	@Override
	public void deleteTheatre(int id) {

		theatreRepo.deleteById(id);
	}

	@Override
	public List<Theatre> allTheatres() {
		// TODO Auto-generated method stub
		return theatreRepo.findAll();
	}

}
