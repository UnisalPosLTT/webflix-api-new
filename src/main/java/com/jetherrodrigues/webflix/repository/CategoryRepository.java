package com.jetherrodrigues.webflix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jetherrodrigues.webflix.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
