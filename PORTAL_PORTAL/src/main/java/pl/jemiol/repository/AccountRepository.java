package pl.jemiol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.jemiol.model.AccountModel;
import pl.jemiol.other.Roles;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long> {
	public void findByRole(Roles roles);
}
