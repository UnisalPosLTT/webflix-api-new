package com.jetherrodrigues.webflix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jetherrodrigues.webflix.domain.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

}
