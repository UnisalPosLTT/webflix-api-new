package com.jetherrodrigues.webflix.resource;

import static com.jetherrodrigues.webflix.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.jetherrodrigues.webflix.domain.Category;
import com.jetherrodrigues.webflix.exceptions.WebflixMovieNotFound;
import com.jetherrodrigues.webflix.service.CategoryService;

@RestController
@RequestMapping(value={
		REST_APP + VERSION_V1 + CATEGORY
})
public class CategoryResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731366882357556547L;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(this.categoryService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Category> getById(@PathVariable(name="id") String id) throws WebflixMovieNotFound {
		Category category = this.categoryService.findById(id);
		
		if(category == null) throw new WebflixMovieNotFound("There is no category with this id!");
		
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(category);
	}
	
	@PostMapping
	public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
		category = this.categoryService.save(category);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(category);
	}
}
