package com.marolix.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marolix.entity.MovieList;
import com.marolix.entity.Theatre;
import com.marolix.repositories.MovieListRepo;
import com.marolix.repositories.TheatreRepo;
import com.marolix.services.MovieListService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/MovieTable")
public class MovieListController {

	@Autowired
	MovieListService movieListService;

	@Autowired
	MovieListRepo movieListRepo;

	@Autowired
	TheatreRepo theatreRepo;

	@GetMapping("/movieList")
	public String movieList(Model model, HttpSession session) {
		if (session.getAttribute("Creditials") == null) {
			return "redirect:/";
		}
		model.addAttribute("movies", movieListService.listMovies());
		return "moviesList";
	}

	@RequestMapping("/addMovie")
	public String addTheatre(Model m, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			return "redirect:/";
		}
		m.addAttribute("theatre", theatreRepo.findAll());
		m.addAttribute("movie", new MovieList());
		return "addMovie";
	}

	@PostMapping("/addMovie")
	public String saveMovie(@ModelAttribute("movie") MovieList movie, Theatre theatre, Model m, HttpSession session) {

		if (session.getAttribute("Creditials") == null) {
			return "redirect:/";
		}

		System.out.println("save Movie");
		movie.setTheatre(movie.getTheatre());
		movieListService.saveMovie(movie);
		m.addAttribute("msg", "inserted Succesfully");
		m.addAttribute("movies", movieListService.listMovies());
		return "redirect:/MovieTable/movieList";
	}

	@PutMapping("/movies")
	public MovieList updateMovie(@RequestBody MovieList movie) {
		return movieListService.saveMovie(movie);
	}

	@GetMapping("/updateMovie/{id}")
	public String updateMovie(@PathVariable("id") Integer id, Model model, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			return "redirect:/";
		}
		MovieList movie = movieListService.findByMovieId(id);
		List<Theatre> theatre = theatreRepo.findAll();
		model.addAttribute("theatre", theatre);
		model.addAttribute("movie", movie);
		return "updateMovie";
	}

	@PostMapping("/updateMovie/{id}")
	public String updatedMovie(@ModelAttribute("movie") MovieList movie, Theatre theatre, Model m,
			HttpSession session) {
		if (session.getAttribute("Creditails") == null) {
			return "redirect:/";
		}
		MovieList existingMovie = movieListService.findByMovieId(movie.getMovieId());
		if (existingMovie != null) {
			existingMovie.setMovieName(movie.getMovieName());
			existingMovie.setGenre(movie.getGenre());
			existingMovie.setTheatre(movie.getTheatre());
			movieListService.saveMovie(existingMovie);
		}
		List<Theatre> theatres = theatreRepo.findAll();
		m.addAttribute("threatre", theatres);
		m.addAttribute("msg", "updated successfully");
		m.addAttribute("movies", movieListService.listMovies());
		return "updateMOvie";

	}

	@GetMapping("/deleteMovie/{id}")
	public String deleteTheatre(@PathVariable("id") Integer Id, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		System.out.println("delete");
		movieListRepo.deleteById(Id);
		return "redirect:/MovieTable/movieList";
	}
}
