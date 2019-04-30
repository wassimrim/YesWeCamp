package com.camping.YesWeCamp.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.camping.YesWeCamp.models.Categorie;
import com.camping.YesWeCamp.services.CategorieService;


@RestController
@RequestMapping("/camp")
public class CategorieController {

	 private static final Logger log = LoggerFactory.getLogger(CategorieController.class);

	@Autowired
	private CategorieService categorieService;

	@GetMapping("/categories")
	public ResponseEntity<Optional<List<Categorie>>> retreiveCategories() {

		if (categorieService.getAllCategorie().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(categorieService.getAllCategorie(), HttpStatus.OK);

	}

	@GetMapping("/categories/{categorieId}")
	public ResponseEntity<Optional<Categorie>> retreiveCategorieById(@PathVariable String categorieId) {

		/*
		 * log.info("information:" + CategorieService.getCategorieById(Long.parseLong(CategorieId)));
		 * log.info("///////////////////");
		 */
		if (!categorieService.getCategorieById(Long.parseLong(categorieId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(categorieService.getCategorieById(Long.parseLong(categorieId)), HttpStatus.OK);
		}
	}

	@PostMapping("/categories")
	public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
		if (categorie.getId() != null) {
			if (categorieService.getCategorieById(categorie.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		Categorie categorieLocal = categorieService.addCategorie(categorie);

		if (categorieLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(categorieLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/categories/{categorieId}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable String categorieId, @RequestBody Categorie categorie) {

		if (categorieService.getCategorieById(categorie.getId()).isPresent()) {

			Categorie categorieLocal = categorieService.updateCategorie(Long.parseLong(categorieId), categorie);

			if (categorieLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(categorieLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/categories/{categorieId}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable String categorieId) {

		if (categorieService.getCategorieById(Long.parseLong(categorieId)).isPresent()) {

			categorieService.deleteCategorie(Long.parseLong(categorieId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CategorieId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
