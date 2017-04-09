package pl.jemiol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.jemiol.other.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long>{
}
