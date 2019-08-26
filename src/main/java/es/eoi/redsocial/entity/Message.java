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
@Table(name = "message")
@Getter
@Setter
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	private String content;

	@Column(name = "publishdate")
	private Date publishdate;

	public Message() {
	}

	public Message(int id, String content, Date publishdate) {
		super();
		this.id = id;
		this.content = content;
		this.publishdate = publishdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", content=");
		builder.append(content);
		builder.append(", publishdate=");
		builder.append(publishdate);
		builder.append("]");
		return builder.toString();
	}

}
