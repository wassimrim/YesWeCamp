package com.camping.YesWeCamp.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.services.EvenementService;

@RestController
public class EvenementController {

	// private static final Logger log =
	// LoggerFactory.getLogger(EvenementController.class);

	@Autowired
	private EvenementService evenementService;

	@GetMapping("/evenements")
	public ResponseEntity<Optional<List<Evenement>>> retreiveEvenements() {

		if (evenementService.getAllEvenement().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(evenementService.getAllEvenement(), HttpStatus.OK);

	}

	@GetMapping("/evenements/{evenementId}")
	public ResponseEntity<Optional<Evenement>> retreiveEvenementById(@PathVariable String evenementId) {

		/*
		 * log.info("information:" + EvenementService.getEvenementById(Long.parseLong(EvenementId)));
		 * log.info("///////////////////");
		 */
		if (!evenementService.getEvenementById(Long.parseLong(evenementId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(evenementService.getEvenementById(Long.parseLong(evenementId)), HttpStatus.OK);
		}
	}

	@PostMapping("/evenements")
	public ResponseEntity<Evenement> addEvenement(@RequestBody Evenement evenement) {
		if (evenement.getId() != null) {
			if (evenementService.getEvenementById(evenement.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		Evenement EvenementLocal = evenementService.addEvenement(evenement);

		if (EvenementLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(EvenementLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/evenements/{evenementId}")
	public ResponseEntity<Evenement> updateEvenement(@PathVariable String evenementId, @RequestBody Evenement evenement) {

		if (evenementService.getEvenementById(evenement.getId()).isPresent()) {

			Evenement EvenementLocal = evenementService.updateEvenement(Long.parseLong(evenementId), evenement);

			if (EvenementLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(EvenementLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/Evenements/{evenementId}")
	public ResponseEntity<Evenement> deleteEvenement(@PathVariable String evenementId) {

		if (evenementService.getEvenementById(Long.parseLong(evenementId)).isPresent()) {

			evenementService.deleteEvenement(Long.parseLong(evenementId));

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evenementId)
					.toUri();

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
