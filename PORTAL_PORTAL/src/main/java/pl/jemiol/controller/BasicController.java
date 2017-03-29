package pl.jemiol.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.jemiol.model.AccountModel;
import pl.jemiol.other.Roles;
import pl.jemiol.repository.AccountRepository;

@Controller
public class BasicController {

	@Autowired
	AccountRepository accountRepository;

	@RequestMapping("/createRandomAccount")
	public ModelAndView createRandomAccount() {
		AccountModel accountmodel = new AccountModel().withUsername(RandomStringUtils.randomAlphabetic(8))
				.withPassword(RandomStringUtils.randomNumeric(4)).withRole(Roles.ROLE_USER);
		accountRepository.save(accountmodel);
		ModelAndView model = new ModelAndView();
		model.addObject("account", accountmodel);
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping("/profile")
	public ModelAndView showAllProfiles() {
		Iterable<AccountModel> results = accountRepository.findAll();
		ModelAndView model = new ModelAndView();
		model.addObject("result", results);
		model.setViewName("welcome");
		return model;
	}

	// @RequestMapping("/profile")
	// public String showAllProfiles(Map<String, Iterable<AccountModel>> map) {
	// Iterable<AccountModel> results = accountRepository.findAll();
	// map.put("messenge", results);
	// return "welcome";
	// }

}
