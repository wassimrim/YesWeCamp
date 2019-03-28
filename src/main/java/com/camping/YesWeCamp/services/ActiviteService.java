package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.ActiviteRestRepository;
import com.camping.YesWeCamp.models.Activite;

@Component
public class ActiviteService {

	private final ActiviteRestRepository activiteRepository;

	public ActiviteService(ActiviteRestRepository activiteRepository) {
		super();
		this.activiteRepository = activiteRepository;
	}

	public Activite addActivite(Activite activite) {
		return activiteRepository.save(activite);
	}

	public Optional<List<Activite>> getAllActivite() {
		List<Activite> activites = new ArrayList<Activite>();

		for (Activite activite : activiteRepository.findAll()) {
			activites.add(activite);
		}
		return Optional.of(activites);
	}

	public Optional<Activite> getActiviteById(Long id) {
		return activiteRepository.findById(id);
	}

	public void deleteActivite(Long id) {

		activiteRepository.deleteById(id);

	}

	public Activite updateActivite(Long id,Activite activite) {
		
		
		Activite activiteFound = activiteRepository.findById(id).get();
		
		
		activiteFound.setLabelle(activite.getLabelle());
		activiteFound.setDescription(activite.getDescription());
		
		activiteRepository.save(activiteFound);
		
		return activiteFound;
	}

}
