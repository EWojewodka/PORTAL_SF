package pl.jemiol.service;

import org.springframework.stereotype.Service;

import pl.jemiol.model.User;

@Service
public interface UserService {
	public void save(User user);

	public User findByUsername(String username);
}
