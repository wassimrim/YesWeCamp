package com.camping.YesWeCamp.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="user")
public class User {

	
	@Id
	@GeneratedValue(strategy =javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String mail;
	private String numTel;
	private LocalDate dateNaissance;
	private String role;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Image> image;

	
	
	    @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	    @JsonManagedReference
	    @JoinTable(name = "inscription",
	            joinColumns = { @JoinColumn(name = "user_id") },
	            inverseJoinColumns = { @JoinColumn(name = "evenement_id") })
	    private Set<Evenement> evenements = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private Set<Article> article;
	
	
	public User() {
		super();
	}
	
	/*public User(Long id, String nom, String prenom, String mail, String numTel, LocalDate dateNaissance, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numTel = numTel;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.inscription=new HashSet<>();
	}*/
	
	


	
	public User(Long id, String nom, String prenom, String mail, String numTel, LocalDate dateNaissance, String role,
			Set<Image> image, Set<Evenement> evenements, Set<Article> article) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numTel = numTel;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.image = image;
		this.evenements = evenements;
		this.article = article;
	}

	
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Set<Image> getImage() {
		return image;
	}

	public void setImage(Set<Image> image) {
		this.image = image;
	}

	

	public Set<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", numTel=" + numTel
				+ ", dateNaissance=" + dateNaissance + ", role=" + role + ", image=" + image + ", evenements="
				+ evenements + ", article=" + article + "]";
	}

	
	
	
	
	
	
	
}
