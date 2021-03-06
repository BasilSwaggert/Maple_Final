package com.caseStudy.spring.services;

import java.util.List;

import com.caseStudy.spring.entities.Tickets;

//Interface contains business logic for Tickets
public interface TicketsService {

	//Saves new or edited tickets to database
    public Tickets save(Tickets tickets);

    //Finds tickets by Id of user associated with the ticket
    public List<Tickets> findTicketsById(int id);
    
    //Finds ticket Id
    public Tickets find(int id);

	List<Tickets> findTicketsByUsername(String username);

	public void delete(int id);
    
}
