package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistanceDto
{

	private int id;

	private int userAssistance;

	private int eventAssistance;

	private String state;

}
