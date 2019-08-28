package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistanceDto
{

	private int id;

	private UserDto userAssistance;

	private EventDto eventAssistance;

	private String state;

}
