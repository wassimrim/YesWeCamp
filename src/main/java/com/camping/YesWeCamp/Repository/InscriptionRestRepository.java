package com.camping.YesWeCamp.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.InscriptionIdentity;
import com.camping.YesWeCamp.models.User;

@RepositoryRestResource(path="inscriptions",collectionResourceRel="inscriptions")
public interface InscriptionRestRepository extends PagingAndSortingRepository<Inscription, InscriptionIdentity> {
	
	
	//Optional<Inscription> findByInscription_User(String userId);
	
	// @Query("select u from inscription_user_evenement u where u.user_id = ?1")
	 List<Inscription> findByUserOrderByIdAsc(User user);
	
	 List<Inscription> findByEvenementOrderByIdAsc(Evenement user);
/*	Optional<Inscription> findByEvenement(Evenement evenement);
	Optional<Inscription> findByUserAndEvenement(User user,Evenement evenement);*/

	/*void deleteByUserAndEvenement(User user,Evenement evenement);*/
}
