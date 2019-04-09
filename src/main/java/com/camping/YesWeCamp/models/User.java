package com.camping.YesWeCamp.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="user")
//@JsonIgnoreProperties({"image","article","inscription"})
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private Set<Article> article;
	
	@JsonBackReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Inscription> inscription;
	
	
	public User() {
		super();
	}
	
	
	public User(Long id, String nom, String prenom, String mail, String numTel, LocalDate dateNaissance, String role,
			Set<Image> image, Set<Article> article) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numTel = numTel;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.image = image;
		this.article = article;
		this.inscription=new HashSet<>();
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

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	
	
	
	
	
	
	public Set<Inscription> getInscription() {
		return inscription;
	}


	public void setInscription(Set<Inscription> inscription) {
		this.inscription = inscription;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", numTel=" + numTel
				+ ", dateNaissance=" + dateNaissance + ", role=" + role + ", image=" + image + ", article=" + article + "]";
	}

	
	
	
	
	
	
	
}
