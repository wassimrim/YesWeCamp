package com.camping.YesWeCamp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.camping.YesWeCamp.Repository.ImageRestRepository;
import com.camping.YesWeCamp.models.Image;

@Component
public class ImageService {

	private final ImageRestRepository imageRepository;

	public ImageService(ImageRestRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	public Image addImage(Image image) {
		return imageRepository.save(image);
	}

	public Optional<List<Image>> getAllImage() {
		List<Image> images = new ArrayList<Image>();

		for (Image image : imageRepository.findAll()) {
			images.add(image);
		}
		return Optional.of(images);
	}

	public Optional<Image> getImageById(Long id) {
		return imageRepository.findById(id);
	}

	public void deleteImage(Long id) {

		imageRepository.deleteById(id);

	}

	public Image updateImage(Long id, Image image) {

		Image imageFound = imageRepository.findById(id).get();

		imageFound.setLabelle(image.getLabelle());

		imageRepository.save(imageFound);

		return imageFound;
	}

	public List<Image> getImagesByUserId(Long id) {
		List<Image> listImages = imageRepository.findByUser(id.toString());
		return listImages;
	}

}
