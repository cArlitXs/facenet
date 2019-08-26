package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reaction")
@Getter
@Setter
public class Reaction {
	
	@Column(name = "idUser")
	private int idUser;
	
	@Column(name = "idMessages")
	private int idMessages;

//	FALTA ReactionType

}
