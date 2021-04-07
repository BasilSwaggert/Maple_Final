package com.caseStudy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.caseStudy.spring.entities.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {

	//Finds users by username
	public Users findByUsername(String username);

	//Repository for many of the CRUD methods used in tandem with Users.
}
