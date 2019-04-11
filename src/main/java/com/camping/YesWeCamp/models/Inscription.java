package com.camping.YesWeCamp.models;


import java.time.LocalDate;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "inscription_user_evenement")
//@JsonIgnoreProperties({"user","evenement"})
public class Inscription  {

	 @EmbeddedId
	 InscriptionIdentity id;

	
    @ManyToOne
    @MapsId("user_id")
	@JoinColumn(name = "user_id")
	//@JsonManagedReference
    private User user;

	
	@ManyToOne
	@MapsId("evenement_id")
	@JoinColumn(name = "evenement_id")
	//@JsonManagedReference
    private Evenement evenement;

	private LocalDate dateInscription;

	public Inscription() {
		super();
	}

	public Inscription(InscriptionIdentity id, User user, Evenement evenement, LocalDate dateInscription) {
		super();
		this.id = id;
		this.user = user;
		this.evenement = evenement;
		this.dateInscription = dateInscription;
	}

	public InscriptionIdentity getId() {
		return id;
	}

	public void setId(InscriptionIdentity id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", user=" + user + ", evenement=" + evenement + ", dateInscription="
				+ dateInscription + "]";
	}

	
	
	
	
	
	
	
}
