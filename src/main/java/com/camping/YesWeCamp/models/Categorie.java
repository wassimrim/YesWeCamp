package com.camping.YesWeCamp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo( scope = Categorie.class,
generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id"
)
@Entity
@Table(name = "categorie")
  public class Categorie {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	@OneToMany(mappedBy="categorie")
	private Set<CategerorieEvenement> categorieEvenement;
	
	@OneToMany(mappedBy="categorie")
	private Set<Materiel> materiel;
	
	
	
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
	public Set<CategerorieEvenement> getCategorieEvenement() {
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
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", labelle=" + labelle + ", categorieEvenement=" + categorieEvenement
				+ ", materiel=" + materiel + "]";
	}
	
	
	
	

}
