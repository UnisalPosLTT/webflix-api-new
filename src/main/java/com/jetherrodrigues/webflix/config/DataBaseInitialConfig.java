package com.jetherrodrigues.webflix.config;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jetherrodrigues.webflix.domain.*;
import com.jetherrodrigues.webflix.repository.*;

@Component
public class DataBaseInitialConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent argument) {
		/*
		 * Create and save movie, category and image
		 */
		List<Movie> movies = this.movieRepository.findAll();
		if(movies.isEmpty()) {
			List<Category> categories = new ArrayList<>();
			List<Image> images = new ArrayList<>();
			
			categories.add(this.categoryRepository.save(new Category("ficção")));
			images.add(this.imageRepository.save(new Image("https://vignette.wikia.nocookie.net/alienvspredadorbr/images/a/ae/Alien.jpg/revision/latest?cb=20110307205957&path-prefix=pt-br")));
			
			this.movieRepository.save(new Movie("Alien, O predador", "Os Xenomorfos são uma raça alienígena da série de filmes Alien, "
					+ "também tendo participado dos filmes Alien vs. Predator, Aliens vs. Predator: "
					+ "Requiem e tendo feito uma pequena aparição no filme Predator 2 "
					+ "no qual se pode ver um crânio da criatura.", Year.of(2000).getValue(), images, categories));
		}
	}
}
