package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Status;

@Repository("statusRepository")
public interface StatusRepository extends CrudRepository<Status, Integer> {

//	Object findById(int id);
//
//	void deleteById(int id);
//

}
