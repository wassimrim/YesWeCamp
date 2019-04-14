package com.camping.YesWeCamp.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.InscriptionIdentity;
import com.camping.YesWeCamp.models.User;
import com.camping.YesWeCamp.services.EvenementService;
import com.camping.YesWeCamp.services.InscriptionService;
import com.camping.YesWeCamp.services.UserService;

@RestController
public class InscriptionController {

	private static final Logger log = LoggerFactory.getLogger(InscriptionController.class);

	@Autowired
	private InscriptionService inscriptionService;

	@Autowired
	private UserService userService;
	@Autowired
	private EvenementService evenementService;

	@GetMapping("/inscriptions")
	public ResponseEntity<Optional<List<Inscription>>> retreiveInscriptions() {

		if (inscriptionService.getAllInscription().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(inscriptionService.getAllInscription(), HttpStatus.OK);

	}

	@GetMapping("/inscriptions/{userId}/{evenementId}")
	public ResponseEntity<Optional<Inscription>> retreiveInscriptionByUser(@PathVariable String userId,
			@PathVariable String evenementId) {

		InscriptionIdentity iIdent = new InscriptionIdentity(Long.parseLong(userId), Long.parseLong(evenementId));

		if (!inscriptionService.getInscriptionById(iIdent).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionById(iIdent), HttpStatus.OK);
		}
	}

	@GetMapping("/inscriptions/user/{userId}")
	public ResponseEntity<List<Inscription>> retreiveInscriptionByUser(@PathVariable String userId) {

		if (inscriptionService.getInscriptionByUserId(userId) == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionByUserId(userId), HttpStatus.OK);
		}
	}

	@GetMapping("/inscriptions/evenement/{evenementId}")
	public ResponseEntity<List<Inscription>> retreiveInscriptionByEvenement(@PathVariable String evenementId) {

		if (inscriptionService.getInscriptionByEvenementId(evenementId) == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionByEvenementId(evenementId), HttpStatus.OK);
		}
	}

	@PostMapping("/inscriptions/{userId}/{evenementId}")
	public ResponseEntity<Inscription> addInscription(@PathVariable String userId, @PathVariable String evenementId) {

		Optional<User> user = userService.getUserById(Long.parseLong(userId));
		Optional<Evenement> evenement = evenementService.getEvenementById(Long.parseLong(evenementId));
		InscriptionIdentity iI = new InscriptionIdentity(Long.parseLong(userId), Long.parseLong(evenementId));
		if (!user.isPresent() || (!evenement.isPresent())) {

			return ResponseEntity.notFound().build();
		}

		if (user.isPresent() & (evenement.isPresent())) {
			if (inscriptionService.getInscriptionById(iI).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}

		Inscription inscription = new Inscription(iI, user.get(), evenement.get(), LocalDate.now());
		Inscription inscriptionLocal = inscriptionService.addInscription(inscription);
		if (inscriptionLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionLocal, HttpStatus.OK);
		}
	}



	@DeleteMapping("/inscriptions/{userId}/{evenementId}")
	public ResponseEntity<Inscription> deleteInscription(@PathVariable String userId, @PathVariable String evenementId) {

		InscriptionIdentity iI = new InscriptionIdentity(Long.parseLong(userId), Long.parseLong(evenementId));

		if (inscriptionService.getInscriptionById(iI).isPresent()) {

			inscriptionService.deleteInscriptionById(iI);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(iI).toUri();

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
