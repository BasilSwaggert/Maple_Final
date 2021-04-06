package com.caseStudy.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.caseStudy.spring.entities.Status;
import com.caseStudy.spring.repositories.StatusRepository;



@Service("statusService")
public class StatusServiceImpl implements StatusService{

	@Autowired
    private StatusRepository statusRepository;


    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status find(int id) {
        return statusRepository.findById(id).get();
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void delete(int id) {
    	statusRepository.deleteById(id);
    }
}