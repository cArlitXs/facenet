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

}
