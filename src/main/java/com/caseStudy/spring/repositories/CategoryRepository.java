package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends CrudRepository<Category, Integer> {

//	void deleteById(int id);
//
//	Object findById(int id);

}
