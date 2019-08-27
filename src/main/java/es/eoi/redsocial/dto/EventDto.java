package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto
{

	private int id;

	private String name;

	private String description;

	private String eventdate;

	private UserDto user;

	public EventDto()
	{
	}

	public EventDto(int id, String name, String description, String eventdate)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.eventdate = eventdate;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", eventdate=");
		builder.append(eventdate);
		builder.append("]");
		return builder.toString();
	}

}
