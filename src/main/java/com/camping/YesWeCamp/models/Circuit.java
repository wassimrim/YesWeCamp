package com.camping.YesWeCamp.models;

import java.util.Set;

import javax.persistence.CascadeType;
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

@JsonIdentityInfo( scope = Circuit.class,
generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id"
)
@Entity
@Table(name = "circuit")
public class Circuit {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String type;
	
	@OneToMany(mappedBy="circuit",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Image> image;

	
	
	@ManyToOne
	@JoinColumn(name="evenement_id")
	private Evenement evenement;
	
	public Circuit() {
		super();
	}
	
	
	public Circuit(Long id, String description, String type, Set<Image> image, Evenement evenement) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
		this.image = image;
		this.evenement = evenement;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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


	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	@Override
	public String toString() {
		return "Circuit [id=" + id + ", description=" + description + ", type=" + type + ", image=" + image
				+ ", evenement=" + evenement + "]";
	}
	
	

}
