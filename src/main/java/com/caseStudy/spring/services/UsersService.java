package com.caseStudy.spring.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.caseStudy.spring.entities.Users;

//Interface contains business logic for Users
public interface UsersService extends UserDetailsService {

	//Finds all users
	public Iterable<Users> findAll();

	//Saves new or edited users to database
    public Users save(Users users);

    //Finds users by username
    public Users findByUsername(String username);

    //Deletes users from database and program by Id
    public void delete(int id);

    //Finds users by Id
	public Users find(int id);
	
	
}