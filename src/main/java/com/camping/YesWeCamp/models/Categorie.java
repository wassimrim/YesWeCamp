package com.camping.YesWeCamp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "categorie")
//@JsonIgnoreProperties({"categorieEvenement","materiel"})
  public class Categorie {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String image;
	//@OneToMany(mappedBy="categorie")
	//@JsonBackReference
	//private Set<CategerorieEvenement> categorieEvenement;
	
	//@OneToMany(mappedBy="categorie")
	//@JsonBackReference
	//private Set<Materiel> materiel;
	
	
	
	public Categorie() {
		super();
	}
	public Categorie(Long id, String labelle,String image) {
		super();
		this.id = id;
		this.labelle = labelle;
	    this.image=image;
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
/*	public Set<CategerorieEvenement> getCategorieEvenement() {
		return categorieEvenement;
	}
	public void setCategorieEvenement(Set<CategerorieEvenement> categorieEvenement) {
		this.categorieEvenement = categorieEvenement;
	}
	public Set<Materiel> getMateriel() {
		return materiel;
	}
	public void setMateriel(Set<Materiel> materiel) {
		this.materiel = materiel;
	}
	*/
	
	
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", labelle=" + labelle + "]";
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
