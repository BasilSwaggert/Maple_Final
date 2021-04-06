package com.caseStudy.spring.services;

import com.caseStudy.spring.entities.Category;

public interface CategoryService {

    public Iterable<Category> findAll();

    public Category find(int id);

    public Category save(Category category);

    public void delete(int id);
}
