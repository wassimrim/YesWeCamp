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


import com.camping.YesWeCamp.models.Image;
import com.camping.YesWeCamp.services.ImageService;


@RestController
public class ImageController {

	 private static final Logger log = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	private ImageService imageService;

	@GetMapping("/images")
	public ResponseEntity<Optional<List<Image>>> retreiveImages() {

		if (imageService.getAllImage().filter(g -> g.isEmpty()).isPresent())
			return ResponseEntity.noContent().build();

		return new ResponseEntity<>(imageService.getAllImage(), HttpStatus.OK);

	}

	@GetMapping("/images/{imageId}")
	public ResponseEntity<Optional<Image>> retreiveImageById(@PathVariable String imageId) {

		/*
		 * log.info("information:" + ImageService.getImageById(Long.parseLong(ImageId)));
		 * log.info("///////////////////");
		 */
		if (!imageService.getImageById(Long.parseLong(imageId)).isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(imageService.getImageById(Long.parseLong(imageId)), HttpStatus.OK);
		}
	}

	@PostMapping("/images")
	public ResponseEntity<Image> addImage(@RequestBody Image image) {
		if (image.getId() != null) {
			if (imageService.getImageById(image.getId()).isPresent()) {
				return ResponseEntity.noContent().build();
			}
		}
		log.info("affichage"+image.getEvenement());
		Image imageLocal = imageService.addImage(image);

		if (imageLocal == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(imageLocal, HttpStatus.OK);
		}
	}

	@PutMapping("/images/{imageId}")
	public ResponseEntity<Image> updateImage(@PathVariable String imageId, @RequestBody Image image) {

		if (imageService.getImageById(image.getId()).isPresent()) {

			Image imageLocal = imageService.updateImage(Long.parseLong(imageId), image);

			if (imageLocal == null) {
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<>(imageLocal, HttpStatus.OK);
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/images/{imageId}")
	public ResponseEntity<Image> deleteImage(@PathVariable String imageId) {

		if (imageService.getImageById(Long.parseLong(imageId)).isPresent()) {

			imageService.deleteImage(Long.parseLong(imageId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ImageId)
					.toUri();*/

			// Status

			return ResponseEntity.accepted().build();

		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
