package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hebergement")
public class Hebergement {
	
	@Id
	@GeneratedValue(strategy =javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String adresse;
	private String numTel;
	private String type;
	private int capacite;
	public Hebergement() {
		super();
	}
	public Hebergement(Long id, String labelle, String adresse, String numTel, String type, int capacite) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.adresse = adresse;
		this.numTel = numTel;
		this.type = type;
		this.capacite = capacite;
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
	
	

}
