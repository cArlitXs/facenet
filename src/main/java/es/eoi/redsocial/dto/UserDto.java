package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto
{

	private int id;

	private String name;

	private String surname;

	private String birtdate;

	private String stardate;

	private String user;

	private String pass;

	public UserDto()
	{
	}
	
	

}
