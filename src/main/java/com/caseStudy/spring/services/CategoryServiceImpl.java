package com.caseStudy.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.caseStudy.spring.entities.Category;
import com.caseStudy.spring.repositories.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public Iterable<Category> findAll() {
//        return categoryRepository.findAll();
//    }
//
////    @Override
////    public Category find(int id) {
////        return categoryRepository.findById(id).get();
////    }
//
//    @Override
//    public Category save(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    @Override
//    public void delete(int id) {
//    	categoryRepository.deleteById(id);
//
//    }

}
