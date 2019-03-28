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


import com.camping.YesWeCamp.models.Activite;
import com.camping.YesWeCamp.services.ActiviteService;


@RestController
public class ActiviteController {

	 private static final Logger log = LoggerFactory.getLogger(ActiviteController.class);

	@Autowired
	private ActiviteService activiteService;

	@GetMapping("/activites")
	public ResponseEntity<Optional<List<Activite>>> retreiveActivites() {

		if (activiteService.getAllActivite().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(activiteService.getAllActivite(), HttpStatus.OK);

	}

	@GetMapping("/activites/{activiteId}")
	public ResponseEntity<Optional<Activite>> retreiveActiviteById(@PathVariable String activiteId) {

		/*
		 * log.info("information:" + ActiviteService.getActiviteById(Long.parseLong(ActiviteId)));
		 * log.info("///////////////////");
		 */
		if (!activiteService.getActiviteById(Long.parseLong(activiteId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(activiteService.getActiviteById(Long.parseLong(activiteId)), HttpStatus.OK);
		}
	}

	@PostMapping("/activites")
	public ResponseEntity<Activite> addActivite(@RequestBody Activite activite) {
		if (activite.getId() != null) {
			if (activiteService.getActiviteById(activite.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		log.info("affichage"+activite.getEvenement());
		Activite ActiviteLocal = activiteService.addActivite(activite);

		if (ActiviteLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(ActiviteLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/activites/{activiteId}")
	public ResponseEntity<Activite> updateActivite(@PathVariable String activiteId, @RequestBody Activite activite) {

		if (activiteService.getActiviteById(activite.getId()).isPresent()) {

			Activite activiteLocal = activiteService.updateActivite(Long.parseLong(activiteId), activite);

			if (activiteLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(activiteLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/activites/{activiteId}")
	public ResponseEntity<Activite> deleteActivite(@PathVariable String activiteId) {

		if (activiteService.getActiviteById(Long.parseLong(activiteId)).isPresent()) {

			activiteService.deleteActivite(Long.parseLong(activiteId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ActiviteId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
