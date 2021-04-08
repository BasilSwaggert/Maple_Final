package com.caseStudy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.caseStudy.spring.entities.Users;

//Repository for Users
@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {

	//Finds users by username
	public Users findByUsername(String username);

	//Repository for many of the CRUD methods used in tandem with Users.
}
