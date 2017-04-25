package pl.jemiol.model;

import javax.persistence.*;

@Table(name = "UserInDepth")
@Entity
public class UserInDepth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
}
