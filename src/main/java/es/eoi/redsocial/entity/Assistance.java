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

import es.eoi.redsocial.enums.StateAssist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assistance")
@Getter
@Setter
public class Assistance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "idUser")
	private int idUser;
	
	@ManyToOne
    @JoinColumn(name = "idUser")
	private User userAssistance;
	
	@ManyToOne
	@JoinColumn(name = "idEvent")
	private Event eventAssistance;
	
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private StateAssist state;

}
