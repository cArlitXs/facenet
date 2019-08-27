package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReactionDto
{
	private int id;

	private int userReaction;

	private int messageReaction;

	private String state;

}
