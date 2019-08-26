package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assistance")
@Getter
@Setter
public class Assistance {
	
	@Column(name = "idUser")
	private int idUser;
	
	@Column(name = "idEvent")
	private int idEvent;
	
//	FALTA AssistState

}
