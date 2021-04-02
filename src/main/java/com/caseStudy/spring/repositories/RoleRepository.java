package com.caseStudy.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Role;

@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
