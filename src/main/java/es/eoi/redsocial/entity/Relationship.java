package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "relationship")
@Getter
@Setter
public class Relationship {
	
	@Column(name = "idUser")
	private int idUser;
	
	@Column(name = "idUserFriend")
	private int idUserFriend;

//	FALTA StateRelationship

}
