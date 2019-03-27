package com.camping.YesWeCamp.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
	/* relation avec table image*/
	public User() {
		super();
	}
	public User(Long id, String nom, String prenom, String mail, String numTel, LocalDate dateNaissance, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.numTel = numTel;
		this.dateNaissance = dateNaissance;
		this.role = role;
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
	
	
	
	
}
