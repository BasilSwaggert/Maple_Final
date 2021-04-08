package com.caseStudy.spring.services;

import com.caseStudy.spring.entities.Status;

//Interface contains business logic for Status
public interface StatusService {

	//Finds all statuses
    public Iterable<Status> findAll();

    //Finds status Id
    public Status find(int id);

    //Saves new or edited statuses to database
    public Status save(Status status);

    //Deletes statuses by Id from the database
    public void delete(int id);
    
}