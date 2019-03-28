package com.camping.YesWeCamp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
        scope = CategerorieEvenement.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "categorie"
)
@Entity
@Table(name="categorie_evenement")
public class CategerorieEvenement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="evenement_id")
	private Evenement evenement;
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	@Override
	public String toString() {
		return "CategerorieEvenement [categorie=" + categorie + ", evenement=" + evenement + "]";
	}
	
	
	
	
}
