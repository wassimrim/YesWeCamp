package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String description;
	private String type;
	private float prix;
	/* relation avec image */
	public Evenement() {
		super();
	}
	public Evenement(Long id, String labelle, String description, String type,float prix) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.type = type;
		this.prix=prix;
	}
	public String getLabelle() {
		return labelle;
	}
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
	
	

}
