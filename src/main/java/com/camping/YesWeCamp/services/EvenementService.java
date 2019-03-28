package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.EvenementRestRepository;
import com.camping.YesWeCamp.models.Evenement;

@Component
public class EvenementService {

	private final EvenementRestRepository evenementRepository;

	public EvenementService(EvenementRestRepository evenementRepository) {
		super();
		this.evenementRepository = evenementRepository;
	}

	public Evenement addEvenement(Evenement Evenement) {
		return evenementRepository.save(Evenement);
	}

	public Optional<List<Evenement>> getAllEvenement() {
		List<Evenement> evenements = new ArrayList<Evenement>();

		for (Evenement evenement : evenementRepository.findAll()) {
			evenements.add(evenement);
		}
		return Optional.of(evenements);
	}

	public Optional<Evenement> getEvenementById(Long id) {
		return evenementRepository.findById(id);
	}

	public void deleteEvenement(Long id) {

		evenementRepository.deleteById(id);

	}

	public Evenement updateEvenement(Long id, Evenement Evenement) {

		Evenement evenementFound = evenementRepository.findById(id).get();

		evenementFound.setLabelle(Evenement.getLabelle());
		evenementFound.setDescription(Evenement.getDescription());
		evenementFound.setType(Evenement.getType());
		evenementFound.setPrix(Evenement.getPrix());

		evenementRepository.save(evenementFound);

		return evenementFound;
	}

}
