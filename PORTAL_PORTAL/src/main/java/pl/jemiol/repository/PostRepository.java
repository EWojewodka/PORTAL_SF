package pl.jemiol.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.jemiol.model.Post;
import pl.jemiol.model.User;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
	public Set<Post> findByOwner(User user);
}
