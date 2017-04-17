package pl.jemiol.controller;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import pl.jemiol.model.Post;
import pl.jemiol.repository.PostRepository;
import pl.jemiol.repository.UserRepository;
import pl.jemiol.service.PostAccessServiceImpl;
import pl.jemiol.service.PostValidator;

@Controller
@RequestMapping("/posts")
public class PostController {
	Logger logger = Logger.getLogger(getClass().getName());
	/**
	 * 
	 */
	@Autowired
	PostValidator postValidator;
	/**
	 * 
	 */
	@Autowired
	PostAccessServiceImpl postAccessServiceImpl;
	/**
	 * 
	 */
	@Autowired
	UserRepository userRepository;
	/**
	 * 
	 */
	@Autowired
	PostRepository postRepository;

	/**
	 * 
	 * @return
	 */
	@Autowired
	protected Authentication loggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}

	/**
	 * 
	 * @param model
	 * @param webRequest
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost(Model model,
						  WebRequest webRequest) {
		Post post = new Post();
		post.setContents(webRequest.getParameter("contents"));
		post.setOwner(userRepository.findOne(Integer.parseInt(webRequest.getParameter("owner"))));
		post.setPostAccess(postAccessServiceImpl.findByName(webRequest.getParameter("postAccess")));
		post.setTime(new Date());
		if (postValidator.check(post.getContents(), post.getPostAccess())) {
			logger.warning("Uploaded");
			postRepository.save(post);
			return "redirect:/";
		}
		model.addAttribute("msg", "Failed");
		return "redirect:/";
	}
}
