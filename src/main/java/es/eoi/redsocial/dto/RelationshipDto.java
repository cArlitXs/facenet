package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationshipDto
{

	private int id;

	private int originUser;

	private int targetUser;

	private String state;

	public RelationshipDto() {
		super();
	}

}
