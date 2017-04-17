package pl.jemiol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jemiol.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	
}
