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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.camping.YesWeCamp.models.Materiel;
import com.camping.YesWeCamp.services.MaterielService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/camping")
public class MaterielController {

	 private static final Logger log = LoggerFactory.getLogger(MaterielController.class);

	@Autowired
	private MaterielService materielService;

	@GetMapping("/materiels")
	public ResponseEntity<Optional<List<Materiel>>> retreiveMateriels() {

		if (materielService.getAllMateriel().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(materielService.getAllMateriel(), HttpStatus.OK);

	}

	@GetMapping("/materiels/{materielId}")
	public ResponseEntity<Optional<Materiel>> retreiveMaterielById(@PathVariable String materielId) {

		/*
		 * log.info("information:" + MaterielService.getMaterielById(Long.parseLong(MaterielId)));
		 * log.info("///////////////////");
		 */
		if (!materielService.getMaterielById(Long.parseLong(materielId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(materielService.getMaterielById(Long.parseLong(materielId)), HttpStatus.OK);
		}
	}

	@PostMapping("/materiels")
	public ResponseEntity<Materiel> addMateriel(@RequestBody Materiel materiel) {
		if (materiel.getId() != null) {
			if (materielService.getMaterielById(materiel.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		Materiel materielLocal = materielService.addMateriel(materiel);

		if (materielLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(materielLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/materiels/{materielId}")
	public ResponseEntity<Materiel> updateMateriel(@PathVariable String materielId, @RequestBody Materiel materiel) {

		if (materielService.getMaterielById(materiel.getId()).isPresent()) {

			Materiel materielLocal = materielService.updateMateriel(Long.parseLong(materielId), materiel);

			if (materielLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(materielLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/materiels/{materielId}")
	public ResponseEntity<Materiel> deleteMateriel(@PathVariable String materielId) {

		if (materielService.getMaterielById(Long.parseLong(materielId)).isPresent()) {

			materielService.deleteMateriel(Long.parseLong(materielId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(MaterielId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
