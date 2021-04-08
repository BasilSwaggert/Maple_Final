package com.caseStudy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Role;

//Repository for Role
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	//Repository for many of the CRUD methods used in tandem with Roles.

}
