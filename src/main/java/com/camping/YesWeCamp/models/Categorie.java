package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	public Categorie() {
		super();
	}
	public Categorie(Long id, String labelle) {
		super();
		this.id = id;
		this.labelle = labelle;
	}
	public String getLabelle() {
		return labelle;
	}
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}
	public Long getId() {
		return id;
	}
	
	

}
