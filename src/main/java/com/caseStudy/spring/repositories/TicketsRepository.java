package com.caseStudy.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Tickets;

//Repository for Tickets
@Repository("ticketsRepository")
public interface TicketsRepository extends JpaRepository<Tickets, Integer> {
	
	//Find the user Id
	@Modifying
	@Query("from Tickets where accountByUserId.id = :id")
	public List<Tickets> findTicketsById(@Param("id") int id);
	
	//Repository for many of the CRUD methods used in tandem with Tickets.

}
