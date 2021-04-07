package com.caseStudy.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseStudy.spring.entities.Tickets;
import com.caseStudy.spring.repositories.TicketsRepository;

@Service("ticketsService")
public class TicketsServiceImpl implements TicketsService {

    @Autowired 
    private TicketsRepository ticketsRepository;

//    @Autowired
//    private UsersRepository usersRepository;
//
    @Override
    public Tickets save(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }
//
//    @Override
//    public List<Tickets> findTicketsByUsername(String username) {
//        Users users = usersRepository.findByUsername(username);
//        return ticketsRepository.findTicketsById(account.getId());
//    }
//
//    //placeholder until .get() can be fixed
//	@Override
//	public Tickets find(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
//    @Override
//    public Tickets find(int id) {
//    	return ticketsRepository.findById(id).get();
//    }
}