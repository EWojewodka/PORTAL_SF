package pl.jemiol.model;

import java.util.Set;

import javax.persistence.*;

import pl.jemiol.other.PostAccess;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "contents")
	private String contents;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuthorID")
	private User owner;

	@Column(name = "postAccess")
	@ElementCollection
	private Set<PostAccess> postAccess;
}
