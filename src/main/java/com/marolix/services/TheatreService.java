package com.marolix.services;

import java.util.List;

import com.marolix.entity.Theatre;

public interface TheatreService {

	public List<Theatre> TheatreList();
	
	Theatre saveTheatre(Theatre theatre);
	
	Theatre findByTheatreId(int id);
	
	Theatre updateTheatre(Theatre theatre);
	
	void deleteTheatre(int id);
	
	List<Theatre> allTheatres();
}
