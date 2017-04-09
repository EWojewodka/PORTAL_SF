package pl.jemiol.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pl.jemiol.model.User;
import pl.jemiol.other.Roles;
import pl.jemiol.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
			for (Roles role : user.getRoles()) {
				grantedAuthority.add(new SimpleGrantedAuthority(role.name()));
			}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthority);
	}
}
