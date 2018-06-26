package com.jetherrodrigues.webflix.resource;

import static com.jetherrodrigues.webflix.util.ApiVersionUtil.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.jetherrodrigues.webflix.domain.Image;
import com.jetherrodrigues.webflix.exceptions.WebflixMovieNotFound;
import com.jetherrodrigues.webflix.service.ImageService;

@RestController
@RequestMapping(value={
		REST_APP + VERSION_V1 + IMAGE
})
public class ImageResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731366882357556547L;
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Image>> getAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(this.imageService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Image> getById(@PathVariable(name="id") String id) throws WebflixMovieNotFound {
		Image image = this.imageService.findById(id);
		
		if(image == null) throw new WebflixMovieNotFound("There is no image with this id!");
		
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(image);
	}
	
	@PostMapping
	public ResponseEntity<Image> save(@Valid @RequestBody Image image) {
		image = this.imageService.save(image);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(image);
	}
}
