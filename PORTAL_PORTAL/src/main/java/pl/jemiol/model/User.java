package pl.jemiol.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import pl.jemiol.other.Roles;

@Entity
@Table(name = "user")
public class User {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	/**
	 * 
	 */
	@NotNull
	@NotEmpty
	@Column(name = "username")
	private String username;
	/**
	 * 
	 */
	@NotNull
	@NotEmpty
	@Column(name = "password")
	private String password;
	/**
	 * 
	 */
	@Column(name = "roles")
	@ElementCollection
	private Set<Roles> roles;
	private String passwordConfirm;
	
	@Column(name = "posts")
	@OneToMany(mappedBy="owner")
	private List<Post> posts;
	
	@Column(name = "friends")
	private Set<User> friends;
	
	@Column(name = "watchedPost")
	private Set<Post> watchedPosts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public User withUsername(String username) {
		this.username = username;
		return this;
	}

	public User withPassword(String password) {
		this.password = password;
		return this;
	}

	public User withRole(Set<Roles> roles) {
		this.roles = roles;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
}