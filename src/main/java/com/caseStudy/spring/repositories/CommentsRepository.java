package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Comments;

@Repository("commentsRepository")
public interface CommentsRepository extends CrudRepository<Comments, Integer> {

}
