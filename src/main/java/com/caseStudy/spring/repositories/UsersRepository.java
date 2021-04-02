package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.caseStudy.spring.entities.Users;

@Repository("usersRepository")
public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	public Users findByUsername(String username);
//
//	public void deleteById(int id);
//
//	public Object findById(int id);
//	
//	public Object get(int id);
//
//	
}
