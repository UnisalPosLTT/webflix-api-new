package com.jetherrodrigues.webflix.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetherrodrigues.webflix.domain.Category;
import com.jetherrodrigues.webflix.repository.CategoryRepository;

@Service
public class CategoryService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9044441985294788487L;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public Category findById(String id) {
		return this.categoryRepository.findOne(id);
	}
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
}
