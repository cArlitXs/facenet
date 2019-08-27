package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto 
{

	private int id;

	private String content;

	private String publishdate;

	private int user;

	public MessageDto() {
	}

	public MessageDto(int id, String content, String publishdate) {
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
