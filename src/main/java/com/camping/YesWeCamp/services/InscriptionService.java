/*package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.EvenementRestRepository;
import com.camping.YesWeCamp.Repository.UserRestRepository;
import com.camping.YesWeCamp.models.Evenement;
import com.camping.YesWeCamp.models.User;

@Component
public class InscriptionService {

	@Autowired
	private final UserRestRepository userRestRepository;
	@Autowired
	private final EvenementRestRepository evenementRestRepository;

	public InscriptionService(UserRestRepository userRestRepository,EvenementRestRepository evenementRestRepository) {
		super();
		this.userRestRepository = userRestRepository;
		this.evenementRestRepository=evenementRestRepository;
	}

	public User addInscriptionUserEvenement(Long userId,Long evenementId) {
		
		
	Optional<User> user= userRestRepository.findById(userId);
	Optional<Evenement> evenement = evenementRestRepository.findById(evenementId);
		user.get().getEvenements().add(evenement.get());
		evenement.get().getUsers().add(user.get());
		
		
		return userRestRepository.save(user.get());
	}

	public Optional<List<User>> getAllInscriptions() {
		List users = new ArrayList<>();

		for (User user : userRepository.findAll()) {
			users.add(user);
		}
		return Optional.of(users);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUser(Long id) {

		userRepository.deleteById(id);

	}

	public User updateUser(Long id,User user) {
		
		
		User userFound = userRepository.findById(id).get();
		
		
		userFound.setNom(user.getNom());
		userFound.setPrenom(user.getPrenom());
		userFound.setMail(user.getMail());
		userFound.setNumTel(user.getNumTel());
		userFound.setDateNaissance(user.getDateNaissance());
		userFound.setRole(user.getRole());
		
		userRepository.save(userFound);
		
		return userFound;
	}

}*/
