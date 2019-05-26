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
@Table(name = "materiel")
//@JsonIgnoreProperties({"image","categorie"})
public class Materiel {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String image;
	
	
	//@OneToMany(targetEntity=Image.class,mappedBy="materiel",fetch=FetchType.EAGER)
	//@JsonBackReference
	//private Set<Image> image;
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	//@JsonManagedReference
	private Categorie categorie;
	
	/* liaison categorie*/
	
	public Materiel() {
		super();
	}


	


	public Materiel(Long id, String labelle, Categorie categorie,String image) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.categorie = categorie;
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









	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}





	public Categorie getCategorie() {
		return categorie;
	}





	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}





	@Override
	public String toString() {
		return "Materiel [id=" + id + ", labelle=" + labelle + ", categorie=" + categorie + "]";
	}
	
	
	

}
