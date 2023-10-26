package com.marolix.control;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.marolix.entity.Creditials;
import com.marolix.entity.Login;
import com.marolix.repositories.BookingRepo;
import com.marolix.repositories.CreditailsRepo;
import com.marolix.repositories.LoginRepo;
import com.marolix.repositories.RegistrationPageRepo;
import com.marolix.services.MovieListService;
import com.marolix.services.TheatreService;

import jakarta.servlet.http.HttpSession;

public class Registration_Controller {
	
	RegistrationPageRepo regRepo;
	
	LoginRepo loginRepo;
	
	MovieListService mov;
	
	TheatreService theatreService;
	
	BookingRepo bookRepo;
	
	
	public String user;
	
	public String credits;
	
	CreditailsRepo creditRepo;

	public String index() {
		return "Home";
	}
	
	
	public String indexHome(Model m) {
		m.addAttribute("msg", "InValid Username or PassWord");
		return "Home";
	}
	
	public String showLoginForm() {
		return"/";
	}
	
	public String submitLoginForm(@RequestParam String userId, @RequestParam String password, HttpSession session, Model m) {

		Login  log = loginRepo.findByUserId(userId);
		
		Creditials cr = creditRepo.findByUsername(userId);
		
		m.addAttribute("msg" , "Invalid UserName or PassWord");
		
		
		if(log == null && cr == null)
		{
			return "redirect:/home";	
		}
		else if(log == null)
		{
			if(!cr.getUsername().equals(userId) && cr.getPassCode().equals(password)) {
				credits = userId;
				session.setAttribute("creditials", credits);
				return "redirect:/TheatreTable/List";
			}
		}else if(cr == null && !log.getPassWord().equals(password)) {
			return "redirect:/home";
		}else
		{
			user = userId;
			session.setAttribute("userId", userId);
			return "redirect:/movies";
		}
		
		return "redirect:/home";
	}
	
	public String update(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return updatePass;
	}
	public String UpdatedPass(@RequestParam String pass, Model m, HttpSession session) {
		String useri = (String) session.get
	}
}
