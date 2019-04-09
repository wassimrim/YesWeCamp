package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.camping.YesWeCamp.Repository.InscriptionRestRepository;
import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.User;

@Component
public class InscriptionService {

	private final InscriptionRestRepository inscriptionRepository;

	public InscriptionService(InscriptionRestRepository inscriptionRepository) {
		super();
		this.inscriptionRepository = inscriptionRepository;
	}

	public Inscription addInscription(Inscription inscription) {
		return inscriptionRepository.save(inscription);
	}

	public Optional<List<Inscription>> getAllInscription() {
		List<Inscription> inscriptions = new ArrayList<Inscription>();

		for (Inscription inscription : inscriptionRepository.findAll()) {
			inscriptions.add(inscription);
		}
		return Optional.of(inscriptions);
	}

	public Optional<Inscription> getInscriptionByUserId(User user) {
		return inscriptionRepository.findByUser(user);
	}

	public Optional<Inscription> getInscriptionByEvenementId(Evenement evenement) {
		return inscriptionRepository.findByEvenement(evenement);
	}

	public Optional< Inscription> getInscriptionByUserIdAndEvenementId(User user,Evenement evenement) {
		return inscriptionRepository.findByUserAndEvenement(user, evenement);
	}

	public void deleteInscriptionByUserAndEvenement(User user,Evenement evenement) {

		inscriptionRepository.deleteByUserAndEvenement(user, evenement);

	}

	

}
