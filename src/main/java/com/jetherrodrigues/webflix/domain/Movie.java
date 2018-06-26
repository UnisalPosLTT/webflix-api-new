package com.jetherrodrigues.webflix.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "movie") 
public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8641803422312063514L;
	@Id 
	private String id;
	@JsonInclude(Include.NON_NULL)
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_NULL)
	private int yearOfpublication;
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime created;
	@DBRef
	@JsonInclude(Include.NON_NULL)
	private List<Image> images;
	@DBRef
	@JsonInclude(Include.NON_NULL)
	private List<Category> categories; 
		
	public Movie() {
		this.id = UUID.randomUUID().toString();
		this.created = LocalDateTime.now();
	}
	
	public Movie(String name, String description, int yearOfpublication, List<Image> images, List<Category> categories) {
		this.id = UUID.randomUUID().toString();
		this.created = LocalDateTime.now();
		
		this.name = name;
		this.description = description;
		this.yearOfpublication = yearOfpublication;
		this.images = images;
		this.categories = categories;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPublishIn() {
		return yearOfpublication;
	}

	public void setPublishIn(int yearOfpublication) {
		this.yearOfpublication = yearOfpublication;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Category> getCategory() {
		return categories;
	}

	public void setCategory(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override  
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
