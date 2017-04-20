package pl.jemiol.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import pl.jemiol.model.User;
import pl.jemiol.other.PostAccess;
import pl.jemiol.repository.UserRepository;
import pl.jemiol.service.UserService;
import pl.jemiol.service.UserValidator;

@Controller
public class BasicController {
	
	protected final Logger log = Logger.getLogger(getClass().getName());
	/**
	 * 
	 */
	@Autowired
	protected UserValidator userValidator;
	/**
	 * 
	 */
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, BindingResult bindingResult, WebRequest webRequest, HttpServletRequest request) {
		String username = webRequest.getParameter("username");
		String password = webRequest.getParameter("password");
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
				user.setOnline(true);
				return "redirect:/";
			}
		}
		model.addAttribute("error", "Username or password is invalid.");
		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult,
			Errors errors) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			log.warning(bindingResult.getAllErrors().toString());
			return "registration";
		}
		log.warning("before redirect");
		userService.save(user);
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String index(ModelMap model, WebRequest webRequest, HttpServletRequest request) {
		User loggedUser = userRepository.findByUsername(webRequest.getUserPrincipal().getName());
		Map<String, String> list = new HashMap<String, String>();
		for (PostAccess i : PostAccess.values()) {
			list.put(i.getName(), i.getGlyph());
		}
		request.getSession().setAttribute("userName", loggedUser.getUsername());
		request.getSession().setAttribute("userId", loggedUser.getId());
		request.getSession().setAttribute("user", loggedUser);
		request.getSession().setAttribute("listOfPostAccess",list);
		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	private String index(Model model, BindingResult bindingResult) {
		return "main";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private String logout(HttpServletRequest request, HttpServletResponse response, WebRequest webRequest) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			userRepository.findByUsername(webRequest.getUserPrincipal().getName()).setOnline(false);;
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
