package com.marolix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.entity.MovieList;
import com.marolix.repositories.MovieListRepo;
@Service
public class MovieListServiceImpl  implements MovieListService{

	@Autowired
	private MovieListRepo movierepo;
	
	@Override
	public List<MovieList> listMovies() {
		// TODO Auto-generated method stub
		return movierepo.findAll();
	}

	@Override
	public MovieList saveMovie(MovieList movie) {
		// TODO Auto-generated method stub
		return movierepo.save(movie);
	}

	@Override
	public MovieList findByMovieId(int id) {
		// TODO Auto-generated method stub
		return movierepo.findByMovieId(id);
	}

	@Override
	public MovieList updateMovie(MovieList movie) {
		// TODO Auto-generated method stub
		return movierepo.save(movie);
	}

	@Override
	public void deleteMovie(int id) {
		
		movierepo.deleteById(id);
	}

}
