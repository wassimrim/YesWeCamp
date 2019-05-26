package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.CircuitRestRepository;
import com.camping.YesWeCamp.models.Circuit;

@Component
public class CircuitService {

	private final CircuitRestRepository circuitRepository;

	public CircuitService(CircuitRestRepository circuitRepository) {
		super();
		this.circuitRepository = circuitRepository;
	}

	public Circuit addCircuit(Circuit circuit) {
		return circuitRepository.save(circuit);
	}

	public Optional<List<Circuit>> getAllCircuit() {
		List<Circuit> circuits = new ArrayList<Circuit>();

		for (Circuit circuit : circuitRepository.findAll()) {
			circuits.add(circuit);
		}
		return Optional.of(circuits);
	}

	public Optional<Circuit> getCircuitById(Long id) {
		return circuitRepository.findById(id);
	}

	public void deleteCircuit(Long id) {

		circuitRepository.deleteById(id);

	}

	public Circuit updateCircuit(Long id, Circuit circuit) {

		Circuit circuitFound = circuitRepository.findById(id).get();

		circuitFound.setDescription(circuit.getDescription());
		circuitFound.setType(circuit.getType());
		circuitFound.setImage(circuit.getImage());
		circuitFound.setEvenement(circuit.getEvenement());

		circuitRepository.save(circuitFound);

		return circuitFound;
	}

}
