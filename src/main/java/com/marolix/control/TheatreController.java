package com.marolix.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marolix.entity.Booking;
import com.marolix.entity.Theatre;
import com.marolix.repositories.BookingRepo;
import com.marolix.repositories.MovieListRepo;
import com.marolix.repositories.TheatreRepo;
import com.marolix.services.TheatreService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/TheatreTable")
public class TheatreController {
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private TheatreRepo theaRepo;
	@Autowired
	private MovieListRepo movieListRepo;
	@Autowired
	private BookingRepo bookingRepo;

	@RequestMapping("/List")
	public String TheatreList(Model model, HttpSession session) {
		if (session.getAttribute("creditails") == null) {
			return "redirect:/";
		}
		model.addAttribute("theatres", theatreService.TheatreList());
		System.out.println("List theatre");
		return "theatreList";
	}

	@GetMapping("/TheatreTable/{id}")
	public Theatre findByTheatreId(@PathVariable("id") int id, HttpSession session) {
		if (session.getAttribute("creditails") == null) {

		}
		return theatreService.findByTheatreId(id);
	}

	@RequestMapping("/addTheatre")
	public String addTheatre(Model m, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		m.addAttribute("theatre", new Theatre());
		return "addTheatre";
	}

	@RequestMapping("/saveTheatre")
	public String saveTheatre(@ModelAttribute("theatre") Theatre theatre, Model m, HttpSession session) {
		if (session.getAttribute("creditails") == null) {
			return "redirect:/";
		}
		System.out.println("hello");
		theatreService.saveTheatre(theatre);
		m.addAttribute("msg", "Insert Successfully");
		m.addAttribute("theatres", theatreService.TheatreList());
		return "redirect:/TheatreTable/List";
	}

	@GetMapping("/updateTheatre/{id}")
	public String getupdateTheatre(@PathVariable("id") Integer theatreId, Model m, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		Theatre theatre = theatreService.findByTheatreId(theatreId);
		m.addAttribute("theatre", theatre);
		Theatre th = new Theatre();
		m.addAttribute("th", th);
		return "updateTheatre";
	}

	@PostMapping("/updateTheatre/{id}")
	public String updateTheatre(@ModelAttribute("th") Theatre theatre, Model m, HttpSession session) {
		if (session.getAttribute("creditial") == null) {
			return " redirect:/";
		}
		Theatre existingtheatre = theatreService.findByTheatreId(theatre.getTheatreId());
		if (existingtheatre != null) {
			existingtheatre.setTheatreName(theatre.getTheatreName());
			existingtheatre.setTheatreCapacity(theatre.getTheatreCapacity());
			existingtheatre.setCity(theatre.getCity());

			theatreService.saveTheatre(existingtheatre);

		}

		m.addAttribute("msg", "inserted successfully");
		m.addAttribute("theatres", theatreService.TheatreList());
		return "updateTheatre";
	}
@GetMapping("/deleteTheatre/{id}")
	public String deleteTheatre(@PathVariable("id") Integer Id, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		theaRepo.deleteById(Id);
		System.out.println("delete");
		return "redirect:/TheatreTable/List";
	}
@RequestMapping("/allBookings")
	public String allBookings(Model m, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		List<Booking> booki = bookingRepo.findAll();
		m.addAttribute("bookings", booki);
		return "allBookings";
	}
}
