package pl.jemiol.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.jemiol.other.PostAccess;

@Service
public interface PostAccessService {
	public Set<PostAccess> findAll();

	public PostAccess findByName(String name);
}
