package es.eoi.redsocial.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "bithdate")
	private Date birtdate;

	@Column(name = "stardate")
	private Date stardate;

	@Column(name = "user")
	private String user;

	@Column(name = "pass")
	private String pass;

	public User() {
	}

	public User(int id, String name, String surname, Date birtdate, Date stardate, String user, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birtdate = birtdate;
		this.stardate = stardate;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", birtdate=");
		builder.append(birtdate);
		builder.append(", stardate=");
		builder.append(stardate);
		builder.append(", user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append("]");
		return builder.toString();
	}

}
