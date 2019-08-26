package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.eoi.redsocial.enums.StateRelationship;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "relationship")
@Getter
@Setter
public class Relationship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User originUser;
	
	@Column(name = "idUserFriend")
	private User targetUser;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private StateRelationship state;

}
