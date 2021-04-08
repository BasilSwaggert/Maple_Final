package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Category;

//Repository for Category
@Repository("categoryRepository")
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
