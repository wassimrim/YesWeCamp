package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.HebergementRestRepository;
import com.camping.YesWeCamp.models.Hebergement;

@Component
public class HebergementService {

	private final HebergementRestRepository hebergementRepository;

	public HebergementService(HebergementRestRepository hebergementRepository) {
		super();
		this.hebergementRepository = hebergementRepository;
	}

	public Hebergement addHebergement(Hebergement hebergement) {
		return hebergementRepository.save(hebergement);
	}

	public Optional<List<Hebergement>> getAllHebergement() {
		List<Hebergement> hebergements = new ArrayList<Hebergement>();

		for (Hebergement hebergement : hebergementRepository.findAll()) {
			hebergements.add(hebergement);
		}
		return Optional.of(hebergements);
	}

	public Optional<Hebergement> getHebergementById(Long id) {
		return hebergementRepository.findById(id);
	}

	public void deleteHebergement(Long id) {

		hebergementRepository.deleteById(id);

	}

	public Hebergement updateHebergement(Long id,Hebergement hebergement) {
		
		
		Hebergement hebergementFound = hebergementRepository.findById(id).get();
		
		
		hebergementFound.setLabelle(hebergement.getLabelle());
		hebergementFound.setAdresse(hebergement.getAdresse());
		hebergementFound.setNumTel(hebergement.getNumTel());
		hebergementFound.setType(hebergement.getType());
		hebergementFound.setCapacite(hebergement.getCapacite());
		
		hebergementRepository.save(hebergementFound);
		
		return hebergementFound;
	}

}
