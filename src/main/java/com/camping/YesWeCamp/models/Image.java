package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	
	public Image() {
		super();
	}
	public Image(Long id, String labelle) {
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
