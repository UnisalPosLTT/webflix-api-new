package com.jetherrodrigues.webflix.resource;

import static com.jetherrodrigues.webflix.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.jetherrodrigues.webflix.domain.Movie;
import com.jetherrodrigues.webflix.exceptions.WebflixMovieNotFound;
import com.jetherrodrigues.webflix.service.MovieService;

@RestController
@RequestMapping(value={
		REST_APP + VERSION_V1 + MOVIE
})
public class MovieResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731366882357556547L;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(this.movieService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable(name="id") String id) throws WebflixMovieNotFound {
		Movie movie = this.movieService.findById(id);
		
		if(movie == null) throw new WebflixMovieNotFound("There is no image with this id!");
		
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> saveMovie(@Valid @RequestBody Movie movie) {
		movie = this.movieService.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(movie);
	}
}
