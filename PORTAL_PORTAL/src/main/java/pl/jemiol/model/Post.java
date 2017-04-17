package pl.jemiol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import pl.jemiol.other.PostAccess;

@Entity
@Table(name = "post")
public class Post {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private int id;
	/**
	 * 
	 */
	@Column(name = "contents")
	@NotNull
	@NotEmpty
	private String contents;
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "AuthorID")
	@ElementCollection
	@NotNull
	private User owner;
	/**
	 * In database it's stored in String. Getter and setter and in enums.
	 */
	@Column(name = "postAccess")
	private String postAccess;
	/**
	 * 
	 */
	@JoinColumn(name = "likes")
	@ManyToMany(mappedBy = "id")
	@ElementCollection
	@NotNull
	private List<User> whoLikes = new ArrayList<>();
	/**
	 * 
	 */
	@Column(name = "time")
	private Date time;

	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	/**
	 * Return PostAccess from Enum
	 * @return
	 */
	public PostAccess getPostAccess() {
		return PostAccess.valueOf(postAccess);
	}
	/**
	 * In param you should give PostAccess, not a String.
	 * @param postAccess
	 */
	public void setPostAccess(PostAccess postAccess) {
		this.postAccess = postAccess.name();
	}

	public List<User> getWhoLikes() {
		return whoLikes;
	}

	public void setWhoLikes(List<User> whoLikes) {
		this.whoLikes = whoLikes;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", contents=" + contents + ", owner=" + owner + ", postAccess=" + postAccess
				+ ", whoLikes=" + whoLikes + ", time=" + time + "]";
	}

}
