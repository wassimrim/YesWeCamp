package com.camping.YesWeCamp.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo( scope = InscriptionUserEvenement.class,
generator = ObjectIdGenerators.PropertyGenerator.class,
property = "user"
)
@Entity
@Table(name="inscription_user_evenement")
public class InscriptionUserEvenement  implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@ManyToOne
		@JoinColumn(name="user_id")
		private User user;
		@ManyToOne
		@JoinColumn(name="evenement_id")
		private Evenement evenement;
		private LocalDate dateInscription;
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
		public LocalDate getDateInscription() {
			return dateInscription;
		}
		public void setDateInscription(LocalDate dateInscription) {
			this.dateInscription = dateInscription;
		}

		@Override
		public String toString() {
			return "InscriptionUserEvenement [user=" + user + ", evenement=" + evenement + ", dateInscription="
					+ dateInscription + "]";
		}
		
		
		
		
		
		
		
		
		
		

}
