package pl.jemiol.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import pl.jemiol.other.PostAccess;

@Component
public class PostValidator {

	Logger logger = Logger.getLogger(getClass().getName());

	private boolean checkContents(String contents) {
		return (contents != null || contents != "");
	}

	private boolean checkPostAccess(PostAccess postAccess) {
		return (postAccess != null);
	}

	/**
	 * 
	 * @param contents
	 * @param postAccess
	 * @return
	 */
	public boolean check(String contents, PostAccess postAccess) {
		return (checkContents(contents) && checkPostAccess(postAccess));
	}

}
