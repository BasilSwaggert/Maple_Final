package com.caseStudy.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caseStudy.spring.entities.Tickets;

@Repository("ticketsRepository")
public interface TicketsRepository extends CrudRepository<Tickets, Integer> {

//    @Query
//    public List<Tickets> findTicketsById(@Param("id") int id);
//
//	public Object findById(int id);
}
