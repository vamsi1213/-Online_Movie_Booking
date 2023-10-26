package com.marolix.services;

import java.util.List;

import com.marolix.entity.MovieList;

public interface MovieListService {

	public List<MovieList> listMovies();
	
	public MovieList saveMovie(MovieList movie);

	public MovieList findByMovieId( int id);
	
	public MovieList updateMovie(MovieList movie);
	
	public void deleteMovie(int id);
}
