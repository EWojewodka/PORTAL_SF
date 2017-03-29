package pl.jemiol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.jemiol.other.Roles;

@Entity
@Table(name = "account")
public class AccountModel {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private Roles role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountModel withRole(Roles role) {
		this.role = role;
		return this;
	}

	public AccountModel withUsername(String username) {
		this.username = username;
		return this;
	}

	public AccountModel withPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "] \n";
	}

}
