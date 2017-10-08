package com.spring.recipeweb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.recipeweb.domain.Category;
import com.spring.recipeweb.domain.UnitOfMeasure;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	Optional<Category> findByDescription(String description);
}
