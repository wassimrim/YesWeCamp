package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.MaterielRestRepository;
import com.camping.YesWeCamp.models.Materiel;

@Component
public class MaterielService {

	private final MaterielRestRepository materielRepository;

	public MaterielService(MaterielRestRepository materielRepository) {
		super();
		this.materielRepository = materielRepository;
	}

	public Materiel addMateriel(Materiel materiel) {
		return materielRepository.save(materiel);
	}

	public Optional<List<Materiel>> getAllMateriel() {
		List<Materiel> materiels = new ArrayList<Materiel>();

		for (Materiel materiel : materielRepository.findAll()) {
			materiels.add(materiel);
		}
		return Optional.of(materiels);
	}

	public Optional<Materiel> getMaterielById(Long id) {
		return materielRepository.findById(id);
	}

	public void deleteMateriel(Long id) {

		materielRepository.deleteById(id);

	}

	public Materiel updateMateriel(Long id,Materiel materiel) {
		
		
		Materiel materielFound = materielRepository.findById(id).get();
		
		
		materielFound.setLabelle(materiel.getLabelle());
		materielFound.setImage(materiel.getImage());

		
		materielRepository.save(materielFound);
		
		return materielFound;
	}

}
