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

	public AssistanceDto(int id, int userAssistance, int eventAssistance, String state) {
		super();
		this.id = id;
		this.userAssistance = userAssistance;
		this.eventAssistance = eventAssistance;
		this.state = state;
	}

	public AssistanceDto() {
		super();
	}

	
}
