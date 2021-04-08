package com.caseStudy.spring.services;

import com.caseStudy.spring.entities.Category;

//Interface contains business logic for Category
public interface CategoryService {

	//Finds all categories
    public Iterable<Category> findAll();

    //Finds category Id
    public Category find(int id);

    //Saves new or edited categories to database
    public Category save(Category category);

    //Deletes categories by Id from the database
    public void delete(int id);
}
