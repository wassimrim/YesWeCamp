package com.camping.YesWeCamp.controllers;

import java.net.URI;
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


import com.camping.YesWeCamp.models.Circuit;
import com.camping.YesWeCamp.services.CircuitService;


@RestController
public class CircuitController {

	 private static final Logger log = LoggerFactory.getLogger(CircuitController.class);

	@Autowired
	private CircuitService circuitService;

	@GetMapping("/circuits")
	public ResponseEntity<Optional<List<Circuit>>> retreiveCircuits() {

		if (circuitService.getAllCircuit().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(circuitService.getAllCircuit(), HttpStatus.OK);

	}

	@GetMapping("/circuits/{circuitId}")
	public ResponseEntity<Optional<Circuit>> retreiveCircuitById(@PathVariable String circuitId) {

		/*
		 * log.info("information:" + circuitService.getCircuitById(Long.parseLong(CircuitId)));
		 * log.info("///////////////////");
		 */
		if (!circuitService.getCircuitById(Long.parseLong(circuitId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(circuitService.getCircuitById(Long.parseLong(circuitId)), HttpStatus.OK);
		}
	}

	@PostMapping("/circuits")
	public ResponseEntity<Circuit> addCircuit(@RequestBody Circuit circuit) {
		if (circuit.getId() != null) {
			if (circuitService.getCircuitById(circuit.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		log.info("affichage"+circuit.getEvenement());
		Circuit CircuitLocal = circuitService.addCircuit(circuit);

		if (CircuitLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(CircuitLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/circuits/{circuitId}")
	public ResponseEntity<Circuit> updateCircuit(@PathVariable String circuitId, @RequestBody Circuit circuit) {

		if (circuitService.getCircuitById(circuit.getId()).isPresent()) {

			Circuit CircuitLocal = circuitService.updateCircuit(Long.parseLong(circuitId), circuit);

			if (CircuitLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(CircuitLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/circuits/{circuitId}")
	public ResponseEntity<Circuit> deleteCircuit(@PathVariable String circuitId) {

		if (circuitService.getCircuitById(Long.parseLong(circuitId)).isPresent()) {

			circuitService.deleteCircuit(Long.parseLong(circuitId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(circuitId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
