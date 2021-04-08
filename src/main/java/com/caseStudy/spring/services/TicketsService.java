package com.caseStudy.spring.services;

import java.util.List;

import com.caseStudy.spring.entities.Tickets;

//Interface contains business logic for Tickets
public interface TicketsService {

	//Saves new or edited tickets to database
    public Tickets save(Tickets tickets);

    //Finds tickets by Username of user associated with the ticket
    public List<Tickets> findTicketsByUsername(String username);
    
    //Finds ticket Id
    public Tickets find(int id);
    
}
