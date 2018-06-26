package com.jetherrodrigues.webflix.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetherrodrigues.webflix.domain.Image;
import com.jetherrodrigues.webflix.repository.ImageRepository;

@Service
public class ImageService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9044441985294788487L;

	@Autowired
	private ImageRepository imageRepository;
	
	public Image save(Image image) {
		return this.imageRepository.save(image);
	}
	
	public Image findById(String id) {
		return this.imageRepository.findOne(id);
	}
	
	public List<Image> findAll() {
		return this.imageRepository.findAll();
	}
}
