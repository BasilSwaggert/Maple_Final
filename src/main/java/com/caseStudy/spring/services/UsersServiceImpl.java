package com.caseStudy.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.caseStudy.spring.entities.Users;
import com.caseStudy.spring.repositories.UsersRepository;

//Class implements the business logic of UsersService
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	@Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        if(users == null) {
            throw new UsernameNotFoundException("Username not found for " + username);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(users.getRole().getName()));
        
        return new User(users.getUsername(), users.getPassword(), grantedAuthorities);
    }

    @Override
    public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public void delete(int id) {
    	usersRepository.deleteById(id);
    }
	

    @Override
    public Users find(int id) {
        return usersRepository.findById(id).get();
        
    }
}