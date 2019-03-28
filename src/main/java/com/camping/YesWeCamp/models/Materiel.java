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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo( scope = Materiel.class,
generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id"
)
@Entity
@Table(name = "materiel")
public class Materiel {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	
	
	@OneToMany(targetEntity=Image.class,mappedBy="materiel",fetch=FetchType.EAGER)
	private Set<Image> image;
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	/* liaison categorie*/
	
	public Materiel() {
		super();
	}


	


	public Materiel(Long id, String labelle, Categorie categorie) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.categorie = categorie;
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





	public Set<Image> getImage() {
		return image;
	}





	public void setImage(Set<Image> image) {
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
		return "Materiel [id=" + id + ", labelle=" + labelle + ", image=" + image + ", categorie=" + categorie + "]";
	}
	
	
	

}
