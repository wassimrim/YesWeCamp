package com.camping.YesWeCamp.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "activite")
//@JsonIgnoreProperties({"image","evenement"})
public class Activite {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="evenement_id")
	//@JsonManagedReference
	private Evenement evenement;

	//@OneToMany(targetEntity=Image.class,mappedBy="activite",fetch=FetchType.EAGER)
	//@JsonBackReference
	//private Set<Image> image;
	
	public Activite() {
		super();
	}

	

	public Activite(Long id, String labelle, String description, Evenement evenement) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.evenement = evenement;
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

	public Long getId() {
		return id;
	}

	public Evenement getEvenement() {
		return evenement;
	}



	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}



	/*public Set<Image> getImage() {
		return image;
	}



	public void setImage(Set<Image> image) {
		this.image = image;
	}*/



	@Override
	public String toString() {
		return "Activite [id=" + id + ", labelle=" + labelle + ", description=" + description + ", evenement="
				+ evenement + "]";
	}
	
	

}
