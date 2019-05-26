package com.camping.YesWeCamp.models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "evenement")
//@JsonIgnoreProperties({"image","hebergement","circuit","categorieEvenement","inscription","activite"})
public class Evenement {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String description;
	private String type;
	private float prix;
	private String image;

	/*
	 * @OneToOne(mappedBy = "evenement") //@JsonBackReference private Hebergement
	 * hebergement;
	 * 
	 * @OneToMany(targetEntity = Image.class, mappedBy = "evenement", fetch =
	 * FetchType.EAGER) //@JsonBackReference private Set<Image> image;
	 * 
	 * @OneToMany(targetEntity = Circuit.class, mappedBy = "evenement", fetch =
	 * FetchType.EAGER) //@JsonBackReference private Set<Circuit> circuit;
	 * 
	 * @OneToMany(mappedBy = "evenement") //@JsonBackReference private
	 * Set<CategerorieEvenement> categorieEvenement;
	 * 
	 * 
	 * @OneToMany(mappedBy = "evenement") //@JsonBackReference private
	 * Set<Inscription> inscription;
	 * 
	 * @OneToMany(mappedBy = "evenement") //@JsonBackReference private Set<Activite>
	 * activite;
	 */
	public Evenement() {
		super();
	}

	public Evenement(Long id, String labelle, String description, String type, float prix, Hebergement hebergement,String image) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.type = type;
		this.prix = prix;
		this.image=image;
		/*
		 * this.hebergement = hebergement; this.image = image; this.circuit = circuit;
		 * this.categorieEvenement = categorieEvenement; this.activite = activite;
		 */
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/*
	 * public Set<Image> getImage() { return image; }
	 * 
	 * public void setImage(Set<Image> image) { this.image = image; }
	 * 
	 * public Hebergement getHebergement() { return hebergement; }
	 * 
	 * public void setHebergement(Hebergement hebergement) { this.hebergement =
	 * hebergement; }
	 * 
	 * public Set<Circuit> getCircuit() { return circuit; }
	 * 
	 * public void setCircuit(Set<Circuit> circuit) { this.circuit = circuit; }
	 * 
	 * public Set<CategerorieEvenement> getCategorieEvenement() { return
	 * categorieEvenement; }
	 * 
	 * public void setCategorieEvenement(Set<CategerorieEvenement>
	 * categorieEvenement) { this.categorieEvenement = categorieEvenement; }
	 * 
	 * public Set<Activite> getActivite() { return activite; }
	 * 
	 * public void setActivite(Set<Activite> activite) { this.activite = activite; }
	 * 
	 * public Set<Inscription> getInscription() { return inscription; }
	 * 
	 * public void setInscription(Set<Inscription> inscription) { this.inscription =
	 * inscription; }
	 */
	@Override
	public String toString() {
		return "Evenement [id=" + id + ", labelle=" + labelle + ", description=" + description + ", type=" + type
				+ ", prix=" + prix + "]";
	}

}
