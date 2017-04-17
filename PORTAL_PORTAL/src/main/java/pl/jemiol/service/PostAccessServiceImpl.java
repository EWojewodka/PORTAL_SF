package pl.jemiol.service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import pl.jemiol.other.PostAccess;

@Service
public class PostAccessServiceImpl implements PostAccessService {

	protected final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public Set<PostAccess> findAll() {
		Set<PostAccess> list = new HashSet<PostAccess>();
		for (PostAccess i : PostAccess.values()) {
			list.add(i);
		}
		return list;
	}

	@Override
	public PostAccess findByName(String name) {
		for (PostAccess i : PostAccess.values()) {
			if (name.equals(i.getName())) {
				return i;
			}
		}
		return null;
	}

}
