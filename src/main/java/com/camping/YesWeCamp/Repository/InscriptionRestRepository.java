package com.camping.YesWeCamp.Repository;


import java.util.Optional;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.User;

@RepositoryRestResource(path="inscriptions",collectionResourceRel="inscriptions")
public interface InscriptionRestRepository extends PagingAndSortingRepository<Inscription, Long> {
	
	Optional<Inscription> findByUser(User user);
	Optional<Inscription> findByEvenement(Evenement evenement);
	Optional<Inscription> findByUserAndEvenement(User user,Evenement evenement);

	void deleteByUserAndEvenement(User user,Evenement evenement);

}
