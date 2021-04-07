package com.caseStudy.spring.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.caseStudy.spring.entities.Users;


public interface UsersService extends UserDetailsService {

	public Iterable<Users> findAll();

    public Users save(Users users);

    public Users findByUsername(String username);

    public void delete(int id);

	public Users find(int id);
	
	
}