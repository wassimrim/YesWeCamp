package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.CategorieRestRepository;
import com.camping.YesWeCamp.models.Categorie;

@Component
public class CategorieService {

	private final CategorieRestRepository categorieRepository;

	public CategorieService(CategorieRestRepository categorieRepository) {
		super();
		this.categorieRepository = categorieRepository;
	}

	public Categorie addCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	public Optional<List<Categorie>> getAllCategorie() {
		List<Categorie> categories = new ArrayList<Categorie>();

		for (Categorie categorie : categorieRepository.findAll()) {
			categories.add(categorie);
		}
		return Optional.of(categories);
	}

	public Optional<Categorie> getCategorieById(Long id) {
		return categorieRepository.findById(id);
	}

	public void deleteCategorie(Long id) {

		categorieRepository.deleteById(id);

	}

	public Categorie updateCategorie(Long id,Categorie categorie) {
		
		
		Categorie categorieFound = categorieRepository.findById(id).get();
		
		
		categorieFound.setLabelle(categorie.getLabelle());
		categorieFound.setImage(categorie.getImage());
		
		categorieRepository.save(categorieFound);
		
		return categorieFound;
	}

}
