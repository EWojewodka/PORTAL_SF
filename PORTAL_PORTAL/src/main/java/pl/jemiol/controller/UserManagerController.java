package pl.jemiol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import pl.jemiol.model.User;
import pl.jemiol.repository.UserRepository;
import pl.jemiol.service.UserService;

@Controller
@RequestMapping("/user")
public class UserManagerController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/send-invite-to/{id}", method = RequestMethod.GET)
	public String sendInvite(@PathVariable("id") String id, Model model, WebRequest webRequest) {
		User loggedUser = userRepository.findByUsername(webRequest.getUserPrincipal().getName());
		User userToInvite = userRepository.findOne(Integer.parseInt(id));
		if (userService.sendInviteToFriends(loggedUser, userToInvite)) {
			model.addAttribute("alert", "Invitation is sent");
			return "main";
		}
		model.addAttribute("alert", "Failed action");
		return "main";
	}

	@RequestMapping(value = "/accept-invite/{id}", method = RequestMethod.GET)
	public String acceptInvite(@PathVariable("id") String id, Model model, WebRequest webRequest) {
		User loggedUser = userRepository.findByUsername(webRequest.getUserPrincipal().getName());
		User userToAccept = userRepository.findOne(Integer.parseInt(id));
		userService.acceptInvitedToFriends(loggedUser, userToAccept);
		return "main";
	}

	@RequestMapping(value = "/delete-invite/{id}", method = RequestMethod.GET)
	public String deleteInvite(@PathVariable("id") String id, Model model, WebRequest webRequest) {
		User loggedUser = userRepository.findByUsername(webRequest.getUserPrincipal().getName());
		User userToDeleteInvite = userRepository.findOne(Integer.parseInt(id));
		userService.deleteInvite(loggedUser, userToDeleteInvite);
		return "main";
	}

}
