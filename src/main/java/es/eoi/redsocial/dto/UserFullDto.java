package es.eoi.redsocial.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFullDto
{

	private int id;

	private String name;

	private String surname;

	private String birtdate;

	private String stardate;

	private String user;

	private String pass;
	
	private List<EventDto> events;
	
	private List<MessageDto> mesagges;
	
    private List<AssistanceDto> assistance;
    
    private List<ReactionDto> reaction;

    private List<RelationshipDto> originsUsers;

    private List<RelationshipDto> targetUsers;

	public UserFullDto()
	{
	}

	public UserFullDto(int id, String name, String surname, String birtdate, String stardate, String user, String pass)
	{
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
	public String toString()
	{
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
