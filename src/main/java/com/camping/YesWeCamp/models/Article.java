package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String description;
	private float prix;
	private int quantite;

	/* relation avec table image */

	public Article() {
		super();
	}

	public Article(Long id, String labelle, String description, float prix, int quantite) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

}
