package com.camping.YesWeCamp.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.Inscription;
import com.camping.YesWeCamp.models.User;
import com.camping.YesWeCamp.services.InscriptionService;


@RestController
public class InscriptionController {

	// private static final Logger log =
	// LoggerFactory.getLogger(InscriptionController.class);

	@Autowired
	private InscriptionService inscriptionService;

	@GetMapping("/inscriptions")
	public ResponseEntity<Optional<List<Inscription>>> retreiveInscriptions() {

		if (inscriptionService.getAllInscription().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(inscriptionService.getAllInscription(), HttpStatus.OK);

	}

	@GetMapping("/inscriptions/user")
	public ResponseEntity<Optional<Inscription>> retreiveInscriptionByUser( @RequestBody User user) {

		
		if (!inscriptionService.getInscriptionByUserId(user).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionByUserId(user), HttpStatus.OK);
		}
	}
	
	@GetMapping("/inscriptions/evenement")
	public ResponseEntity<Optional<Inscription>> retreiveInscriptionByEvenement( @RequestBody Evenement evenement) {

		
		if (!inscriptionService.getInscriptionByEvenementId(evenement).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionByEvenementId(evenement), HttpStatus.OK);
		}
	}
	
	@GetMapping("/inscriptions/user/evenement")
	public ResponseEntity<Optional<Inscription>> retreiveInscriptionByUserAndEvenement( @RequestBody User user,@RequestBody Evenement evenement) {

		
		if (!inscriptionService.getInscriptionByUserIdAndEvenementId(user, evenement).isPresent() ) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionService.getInscriptionByUserIdAndEvenementId(user, evenement), HttpStatus.OK);
		}
	}


	@PostMapping("/inscriptions")
	public ResponseEntity<Inscription> addInscription(@RequestBody Inscription inscription ) {
		if ((inscription.getEvenement() != null) & (inscription.getUser()!=null)) {
			if (inscriptionService.getInscriptionByUserIdAndEvenementId(inscription.getUser(), inscription.getEvenement()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		Inscription inscriptionLocal = inscriptionService.addInscription(inscription);

		if (inscriptionLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(inscriptionLocal, HttpStatus.OK);
		}
	}

	

	@DeleteMapping("/inscriptions/user/evenement")
	public ResponseEntity<Inscription> deleteInscription(@RequestBody Inscription inscription) {

		if (inscriptionService.getInscriptionByUserIdAndEvenementId(inscription.getUser(), inscription.getEvenement()).isPresent()) {

			inscriptionService.deleteInscriptionByUserAndEvenement(inscription.getUser(), inscription.getEvenement());

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inscription)
					.toUri();

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}

