package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto 
{

	private Integer id;

	private String content;

	private String publishdate;

	private Integer user;

}
