package pl.jemiol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.jemiol.other.PostAccess;

@Repository
public interface PostAccessRepository extends CrudRepository<PostAccess, Long>{

}
