package pl.jemiol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import pl.jemiol.model.User;
import pl.jemiol.repository.UserRepository;
import pl.jemiol.service.UserService;
import pl.jemiol.service.UserValidator;

@Controller
public class BasicController {

	@Autowired
	protected UserValidator userValidator;

	@Autowired
	protected UserService userService;
	/**
	 * 
	 */
	@Autowired
	protected UserRepository userRepository;
	/**
	 * 
	 */
	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * 
	 * @return
	 */
	@Autowired
	protected Authentication loggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, BindingResult bindingResult, WebRequest webRequest) {
		String username = webRequest.getParameter("username");
		String password = webRequest.getParameter("password");
		User user = userService.findByUsername(username);
		if (user != null) {
			if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
				return "/index";
			}
		}
		
		return "/";
	}
}
