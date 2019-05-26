package com.camping.YesWeCamp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="hebergement")
@JsonIgnoreProperties({"evenement"})
public class Hebergement {
	
	@Id
	@GeneratedValue(strategy =javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String adresse;
	private String numTel;
	private String type;
	private int capacite;
	private String image;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="evenement_id")
	//@JsonManagedReference
	private Evenement evenement;
	
	public Hebergement() {
		super();
	}
	
	public Hebergement(Long id, String labelle,String image, String adresse, String numTel, String type, int capacite,
			Evenement evenement) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.adresse = adresse;
		this.numTel = numTel;
		this.type = type;
		this.capacite = capacite;
		this.evenement = evenement;
		this.image=image;
	}

	public Long getId() {
		return id;
	}
	
	public String getLabelle() {
		return labelle;
	}
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenemet) {
		this.evenement = evenemet;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Hebergement [id=" + id + ", labelle=" + labelle + ", adresse=" + adresse + ", numTel=" + numTel
				+ ", type=" + type + ", capacite=" + capacite + ", evenement=" + evenement + "]";
	}
	
	
	

}
