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
import com.fasterxml.jackson.annotation.JsonManagedReference;



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
	@ManyToOne
	@JoinColumn(name="user_id")
	//@JsonManagedReference
	private User user;
	
	//@OneToMany(targetEntity=Image.class,mappedBy="article",fetch=FetchType.EAGER)
	//@JsonBackReference
	//private Set<Image> image;
	

	public Article() {
		super();
	}



	public Article(Long id, String labelle, String description, float prix, int quantite, User user) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.user = user;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	/*public Set<Image> getImage() {
		return image;
	}



	public void setImage(Set<Image> image) {
		this.image = image;
	}*/



	@Override
	public String toString() {
		return "Article [id=" + id + ", labelle=" + labelle + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + ", user=" + user + "]";
	}
	
	
    
}
