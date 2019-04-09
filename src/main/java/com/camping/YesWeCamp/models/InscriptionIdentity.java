package com.camping.YesWeCamp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InscriptionIdentity implements Serializable  {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	    Long UserId;
	 
	    @Column(name = "evenement_id")
	    Long EvenementId;

		public InscriptionIdentity() {
			super();
		}

		public InscriptionIdentity(Long userId, Long evenementId) {
			super();
			UserId = userId;
			EvenementId = evenementId;
		}

		public Long getUserId() {
			return UserId;
		}

		public void setUserId(Long userId) {
			UserId = userId;
		}

		public Long getEvenementId() {
			return EvenementId;
		}

		public void setEvenementId(Long evenementId) {
			EvenementId = evenementId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((EvenementId == null) ? 0 : EvenementId.hashCode());
			result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			InscriptionIdentity other = (InscriptionIdentity) obj;
			if (EvenementId == null) {
				if (other.EvenementId != null)
					return false;
			} else if (!EvenementId.equals(other.EvenementId))
				return false;
			if (UserId == null) {
				if (other.UserId != null)
					return false;
			} else if (!UserId.equals(other.UserId))
				return false;
			return true;
		}

	
	
	    
}
