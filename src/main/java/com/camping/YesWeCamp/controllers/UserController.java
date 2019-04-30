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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camping.YesWeCamp.models.User;
import com.camping.YesWeCamp.services.UserService;

@RestController
@RequestMapping("/camp")
public class UserController {

	// private static final Logger log =
	// LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<Optional<List<User>>> retreiveUsers() {

		if (userService.getAllUser().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);

	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<Optional<User>> retreiveUserById(@PathVariable String userId) {

		/*
		 * log.info("information:" + userService.getUserById(Long.parseLong(userId)));
		 * log.info("///////////////////");
		 */
		if (!userService.getUserById(Long.parseLong(userId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(userService.getUserById(Long.parseLong(userId)), HttpStatus.OK);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if (user.getId() != null) {
			if (userService.getUserById(user.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		User userLocal = userService.addUser(user);

		if (userLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(userLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {

		if (userService.getUserById(user.getId()).isPresent()) {

			User userLocal = userService.updateUser(Long.parseLong(userId), user);

			if (userLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(userLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {

		if (userService.getUserById(Long.parseLong(userId)).isPresent()) {

			userService.deleteUser(Long.parseLong(userId));

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userId)
					.toUri();

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
