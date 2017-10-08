package com.spring.recipeweb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.recipeweb.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	Optional<UnitOfMeasure> findByDescription(String description);
}
