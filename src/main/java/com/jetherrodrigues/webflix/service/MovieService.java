package com.jetherrodrigues.webflix.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetherrodrigues.webflix.domain.Movie;
import com.jetherrodrigues.webflix.repository.MovieRepository;

@Service
public class MovieService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9044441985294788487L;

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie save(Movie movie) {
		return this.movieRepository.save(movie);
	}
	
	public Movie findById(String id) {
		return this.movieRepository.findOne(id);
	}
	
	public List<Movie> findAll() {
		return this.movieRepository.findAll();
	}
}
