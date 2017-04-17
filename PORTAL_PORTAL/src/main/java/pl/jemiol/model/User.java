package pl.jemiol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
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
	private int id;
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
	 * In database it's stored like a String, but setter and getter are in Roles
	 * type.
	 */
	@Column(name = "roles")
	@NotNull
	private String roles = "USER";
	/**
	 * 
	 */
	private String passwordConfirm;
	/**
	 * 
	 */
	@Column(name = "posts")
	@OneToMany(mappedBy = "owner")
	private List<Post> posts;
	/**
	 * 
	 */
	@Column(name = "friends")
	@ManyToMany
	private List<User> friends = new ArrayList<User>();
	/**
	 * 
	 */
	@Column(name = "invitedBy")
	@ManyToMany
	private List<User> invitedBy = new ArrayList<User>();
	/**
	 * 
	 */
	@Column(name = "invitedFriends")
	@ManyToMany(mappedBy = "invitedBy")
	private List<User> invitedFriends = new ArrayList<User>();
	/**
	 * 
	 */
	@Column(name = "watchedPost")
	@ElementCollection
	private List<Post> watchedPosts = new ArrayList<Post>();
	/**
	 * 
	 */
	@Column(name = "post_likes")
	@ElementCollection
	private List<Post> postLikes = new ArrayList<Post>();
	/**
	 * 
	 */
	// TODO DOESN'T WORK.
	@Column(name = "online")
	private boolean online = false;

	/**
	 * 
	 * @return
	 */
	public List<Post> getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(List<Post> postLikes) {
		this.postLikes = postLikes;
	}

	public List<User> getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(ArrayList<User> invitedBy) {
		this.invitedBy = invitedBy;
	}

	public List<User> getInvitedFriends() {
		return invitedFriends;
	}

	public void setInvitedFriends(ArrayList<User> invitedFriends) {
		this.invitedFriends = invitedFriends;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	/**
	 * This getter return Roles Enum
	 * 
	 * @return
	 */
	public Roles getRoles() {
		return Roles.valueOf(roles);
	}

	/**
	 * You should give in param role from enum, not a String.
	 * 
	 * @param roles
	 */
	public void setRoles(Roles roles) {
		this.roles = roles.name();
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public List<Post> getWatchedPosts() {
		return watchedPosts;
	}

	public void setWatchedPosts(List<Post> watchedPosts) {
		this.watchedPosts = watchedPosts;
	}

}