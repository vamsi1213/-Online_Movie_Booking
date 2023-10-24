package com.marolix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie_list")
public class MovieList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	@Column(name = "moviename")
	private String movieName;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name = "moviename")
	
	private Theatre theatre;

	public MovieList() {
		super();
	}
	public MovieList(Integer movieId, String movieName, String genre, Theatre theatre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.theatre = theatre;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	@Override
	public String toString() {
		return "MovieList [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", theatre="
				+ theatre + "]";
	}
	
	
	
	
	
}
