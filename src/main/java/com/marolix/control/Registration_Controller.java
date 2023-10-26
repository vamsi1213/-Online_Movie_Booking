package com.marolix.control;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marolix.entity.Booking;
import com.marolix.entity.Creditials;
import com.marolix.entity.Login;
import com.marolix.entity.MovieList;
import com.marolix.entity.RegistrationPage;
import com.marolix.repositories.BookingRepo;
import com.marolix.repositories.CreditailsRepo;
import com.marolix.repositories.LoginRepo;
import com.marolix.repositories.RegistrationPageRepo;
import com.marolix.services.MovieListService;
import com.marolix.services.TheatreService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Registration_Controller {

	@Autowired
	RegistrationPageRepo regRepo;

	@Autowired
	LoginRepo loginRepo;

	@Autowired
	MovieListService mov;
	@Autowired
	TheatreService theatreService;
	@Autowired
	BookingRepo bookRepo;

	public String user;

	public String credits;

	@Autowired
	CreditailsRepo creditRepo;

	@GetMapping("/")
	public String index() {
		return "Home";
	}

	@GetMapping("/home")
	public String indexHome(Model m) {
		m.addAttribute("msg", "InValid Username or PassWord");
		return "Home";
	}

	@GetMapping("/loginPage")
	public String showLoginForm() {
		return "/";
	}

	@PostMapping("/loginPage")

	public String submitLoginForm(@RequestParam String userId, @RequestParam String password, HttpSession session,
			Model m) {

		Login log = loginRepo.findByUserId(userId);

		Creditials cr = creditRepo.findByUsername(userId);

		m.addAttribute("msg", "Invalid UserName or PassWord");

		if (log == null && cr == null) {
			return "redirect:/home";
		} else if (log == null) {
			if (!cr.getUsername().equals(userId) && cr.getPassCode().equals(password)) {
				credits = userId;
				session.setAttribute("creditials", credits);
				return "redirect:/TheatreTable/List";
			}
		} else if (cr == null && !log.getPassWord().equals(password)) {
			return "redirect:/home";
		} else {
			user = userId;
			session.setAttribute("userId", userId);
			return "redirect:/movies";
		}

		return "redirect:/home";
	}

	@GetMapping("/updatePass")
	public String update(HttpSession session) {
		if (session.getAttribute("userID") == null) {
			return "redirect:/";
		}
		return "updatePass";
	}

	@PostMapping("/updatePass")
	public String UpdatedPass(@RequestParam String pass, Model m, HttpSession session) {
		String useri = (String) session.getAttribute("userId");

		Login log = loginRepo.findByUserId(useri);
		log.setPassWord(pass);
		loginRepo.save(log);
		m.addAttribute("msg", "Updated Password Successfully");
		return "updatedPass";
	}

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("Customer", new RegistrationPage());
		m.addAttribute("lg", new Login());
		return "register";
	}

	@RequestMapping("/loginInsert")
	public ModelAndView loginInsert(@ModelAttribute("customer") RegistrationPage customer,
			@ModelAttribute("lg") Login lg, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		regRepo.save(customer);
		System.out.println("Ramdom entry");

		Random rdm = new Random();
		int randomnum = rdm.nextInt(9000) + 1000;

		String name = customer.getName();
		String regId = name.substring(0, 2).toUpperCase() + randomnum;
		String pass = password;
		lg.setUserId(regId);
		lg.setPassWord(pass);
		lg.setRegister(customer);
		loginRepo.save(lg);

		String s = lg.getUserId();
		String ss = lg.getPassWord();
		mv.addObject("cust", s);
		mv.addObject("pass", ss);
		System.out.println(lg.getId());
		mv.setViewName("User Login Details ");

		return mv;
	}

	@GetMapping("/userLoginDetails")
	public String loginDetails() {
		return "userLoginDetails";
	}

	@GetMapping("/movies")
	public String listMovies(Model model, HttpSession session) {
		model.addAttribute("movies", mov.listMovies());
		return "movies";
	}

	@GetMapping("/movies/{id}")
	public String bookMovieTicket(@PathVariable("id") Integer id, HttpSession session, Model model, Booking booking) {

		if (user == null || session.getAttribute("userId") == null) {
			;
			return "redirect:/";
		}
		model.addAttribute("movies", mov.listMovies());
		model.addAttribute("bookingId", booking);
		return "booking";
	}

	@PostMapping("/movies/{id}")
	public String bookedMovie(@ModelAttribute("bookingId") Booking booking, HttpSession session, Model model,
			MovieList mov) {
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		bookRepo.save(booking);
		booking.setMovieName(booking.getMovieName());
		booking.setTheatreName(booking.getTheatreName());
		booking.setPrice(booking.getPrice() * booking.getSeats());
		booking.setUserId(user);
		bookRepo.save(booking);

		model.addAttribute("book", "Booked successfully");

		model.addAttribute("booking", booking);

		return "creditcard";
	}

	@PostMapping("/myBookings")
	public String myBookings(Model m, Booking booking, HttpSession session) {
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Booking> booki = bookRepo.findAllByUserId(user);

		m.addAttribute("book", "Booked successfully!!!");

		m.addAttribute("bookings", booki);

		return "myBookings";
	}

	@GetMapping("/myBookings")
	public String myBooking(Model m, Booking booking, HttpSession session) {

		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:/";
		}

		List<Booking> booki = bookRepo.findAllByUserId(user);
		m.addAttribute("bookings", booki);
		return "myBookings";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Home";
	}

	@GetMapping("/allBookings")
	public String allUserBookings(Model m, Booking booking, HttpSession session) {
		if (session.getAttribute("creditials") == null) {
			return "redirect:/";
		}
		List<Booking> booki = bookRepo.findAll();
		m.addAttribute("Bookings", booki);
		return "allBookings";
	}
}
