package com.camping.YesWeCamp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
        scope = Image.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="evenement_id")
	private Evenement evenement;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="circuit_id")
	private Circuit circuit;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="activite_id")
	private Activite activite;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="materiel_id")
	private Materiel materiel;
	
	public Image() {
		super();
	}

	


	public Image(Long id, String labelle, User user, Evenement evenement, Circuit circuit, Article article,
			Activite activite, Materiel materiel) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.user = user;
		this.evenement = evenement;
		this.circuit = circuit;
		this.article = article;
		this.activite = activite;
		this.materiel = materiel;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}



	public Circuit getCircuit() {
		return circuit;
	}



	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}




	public Article getArticle() {
		return article;
	}




	public void setArticle(Article article) {
		this.article = article;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}




	public Materiel getMateriel() {
		return materiel;
	}




	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}




	@Override
	public String toString() {
		return "Image [id=" + id + ", labelle=" + labelle + ", user=" + user + ", evenement=" + evenement + ", circuit="
				+ circuit + ", article=" + article + ", activite=" + activite + ", materiel=" + materiel + "]";
	}
	
	
	
	
}
