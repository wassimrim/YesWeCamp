package com.camping.YesWeCamp.models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo( scope = Evenement.class,
generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id"
)
@Entity
@Table(name = "evenement")
public class Evenement {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	private String description;
	private String type;
	private float prix;

	@OneToOne(mappedBy="evenement")
	private Hebergement hebergement;
	
	@OneToMany(targetEntity=Image.class,mappedBy="evenement",fetch=FetchType.EAGER)
	private Set<Image> image;
	
	
	@OneToMany(targetEntity=Circuit.class,mappedBy="evenement",fetch=FetchType.EAGER)
	private Set<Circuit> circuit;

	
	@OneToMany(mappedBy="evenement")
	private Set<CategerorieEvenement> categorieEvenement;
	
	@OneToMany(mappedBy = "evenement")
	private Set<InscriptionUserEvenement>  inscription;
	
	@OneToMany(mappedBy = "evenement")
	private Set<Activite>  activite;
	
	public Evenement() {
		super();
	}
	
	



	public Evenement(Long id, String labelle, String description, String type, float prix, Hebergement hebergement) {
		super();
		this.id = id;
		this.labelle = labelle;
		this.description = description;
		this.type = type;
		this.prix = prix;
		this.hebergement = hebergement;
		
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
	public Set<InscriptionUserEvenement> getInscription() {
		return inscription;
	}
	public void setInscription(Set<InscriptionUserEvenement> inscription) {
		this.inscription = inscription;
	}



	public Set<Image> getImage() {
		return image;
	}



	public void setImage(Set<Image> image) {
		this.image = image;
	}



	public Hebergement getHebergement() {
		return hebergement;
	}



	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}





	public Set<Circuit> getCircuit() {
		return circuit;
	}





	public void setCircuit(Set<Circuit> circuit) {
		this.circuit = circuit;
	}





	public Set<CategerorieEvenement> getCategorieEvenement() {
		return categorieEvenement;
	}





	public void setCategorieEvenement(Set<CategerorieEvenement> categorieEvenement) {
		this.categorieEvenement = categorieEvenement;
	}





	public Set<Activite> getActivite() {
		return activite;
	}





	public void setActivite(Set<Activite> activite) {
		this.activite = activite;
	}





	@Override
	public String toString() {
		return "Evenement [id=" + id + ", labelle=" + labelle + ", description=" + description + ", type=" + type
				+ ", prix=" + prix + ", hebergement=" + hebergement + ", image=" + image + ", circuit=" + circuit
				+ ", categorieEvenement=" + categorieEvenement + ", inscription=" + inscription + ", activite="
				+ activite + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
