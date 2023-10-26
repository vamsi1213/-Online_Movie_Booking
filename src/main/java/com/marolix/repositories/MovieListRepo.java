package com.marolix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marolix.entity.MovieList;

@Repository
public interface MovieListRepo extends JpaRepository<MovieList, Integer>, CrudRepository<MovieList, Integer>{

	MovieList findByMovieId(int id);
}
