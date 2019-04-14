package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.EvenementRestRepository;
import com.camping.YesWeCamp.Repository.InscriptionRestRepository;
import com.camping.YesWeCamp.Repository.UserRestRepository;
import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.InscriptionIdentity;
import com.camping.YesWeCamp.models.User;

@Component
public class InscriptionService {

	private final InscriptionRestRepository inscriptionRepository;
	private final UserRestRepository userRepository;
	private final EvenementRestRepository evenementRepository;

	public InscriptionService(InscriptionRestRepository inscriptionRepository, UserRestRepository userRepository,
			EvenementRestRepository evenementRepository) {
		super();
		this.inscriptionRepository = inscriptionRepository;
		this.userRepository = userRepository;
		this.evenementRepository = evenementRepository;
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

	public Optional<Inscription> getInscriptionById(InscriptionIdentity inscrptionIdentity) {
		return inscriptionRepository.findById(inscrptionIdentity);
	}

	public List<Inscription> getInscriptionByUserId(String idUser) {

		Optional<User> user = userRepository.findById(Long.parseLong(idUser));

		return inscriptionRepository.findByUserOrderByIdAsc(user.get());
	}

	public List<Inscription> getInscriptionByEvenementId(String idEvenement) {

		Optional<Evenement> evenement = evenementRepository.findById(Long.parseLong(idEvenement));

		return inscriptionRepository.findByEvenementOrderByIdAsc(evenement.get());
	}

	/*
	 * public Optional< Inscription> getInscriptionByUserIdAndEvenementId(User
	 * user,Evenement evenement) { return
	 * inscriptionRepository.findByUserAndEvenement(user, evenement); }
	 **/
	public void deleteInscriptionById(InscriptionIdentity iIdentity) {

		inscriptionRepository.deleteById(iIdentity);

	}
}
