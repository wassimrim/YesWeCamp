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
import org.springframework.web.bind.annotation.RestController;


import com.camping.YesWeCamp.models.Hebergement;
import com.camping.YesWeCamp.services.HebergementService;


@RestController
public class HebergementController {

	 private static final Logger log = LoggerFactory.getLogger(HebergementController.class);

	@Autowired
	private HebergementService hebergementService;

	@GetMapping("/hebergements")
	public ResponseEntity<Optional<List<Hebergement>>> retreiveHebergements() {

		if (hebergementService.getAllHebergement().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(hebergementService.getAllHebergement(), HttpStatus.OK);

	}

	@GetMapping("/hebergements/{hebergementId}")
	public ResponseEntity<Optional<Hebergement>> retreiveHebergementById(@PathVariable String hebergementId) {

		/*
		 * log.info("information:" + HebergementService.getHebergementById(Long.parseLong(HebergementId)));
		 * log.info("///////////////////");
		 */
		if (!hebergementService.getHebergementById(Long.parseLong(hebergementId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(hebergementService.getHebergementById(Long.parseLong(hebergementId)), HttpStatus.OK);
		}
	}

	@PostMapping("/hebergements")
	public ResponseEntity<Hebergement> addHebergement(@RequestBody Hebergement hebergement) {
		if (hebergement.getId() != null) {
			if (hebergementService.getHebergementById(hebergement.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		log.info("affichage"+hebergement.getEvenement());
		Hebergement hebergementLocal = hebergementService.addHebergement(hebergement);

		if (hebergementLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(hebergementLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/hebergements/{hebergementId}")
	public ResponseEntity<Hebergement> updateHebergement(@PathVariable String hebergementId, @RequestBody Hebergement hebergement) {

		if (hebergementService.getHebergementById(hebergement.getId()).isPresent()) {

			Hebergement hebergementLocal = hebergementService.updateHebergement(Long.parseLong(hebergementId), hebergement);

			if (hebergementLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(hebergementLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/hebergements/{hebergementId}")
	public ResponseEntity<Hebergement> deleteHebergement(@PathVariable String hebergementId) {

		if (hebergementService.getHebergementById(Long.parseLong(hebergementId)).isPresent()) {

			hebergementService.deleteHebergement(Long.parseLong(hebergementId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(HebergementId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
