package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Comments;

@Repository("commentsRepository")
public interface CommentsRepository extends CrudRepository<Comments, Integer> {

	//Looking to implement this down the line so that people with the Employee and Admin Roles
	//are able to add comments in the Ticket Details, detailing the work that has been done.
}
