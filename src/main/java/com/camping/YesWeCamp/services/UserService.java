package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.UserRestRepository;
import com.camping.YesWeCamp.models.User;

@Component
public class UserService {

	private final UserRestRepository userRepository;

	public UserService(UserRestRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public Optional<List<User>> getAllUser() {
		List<User> users = new ArrayList<User>();

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

}
