package com.caseStudy.spring;


import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.caseStudy.spring.entities.Status;
import com.caseStudy.spring.repositories.StatusRepository;
import com.caseStudy.spring.services.StatusService;

@ExtendWith(MockitoExtension.class)
public class StatusServiceTest {

//	@Mock
//	private StatusRepository statusRepository;
//	
//	@InjectMocks
//	private StatusService statusService;
//	
//	@Test
//	void testFind() {
//		final Integer id = 1;
//		final Status status = new Status("Test", true, "Test1");
//		
//		given(statusRepository.findById(id)).willReturn(Optional.of(status));
//		
//		final Optional<Status> expected = statusService.find(id);
//		
//		assertThat(expected).isNotNull();
//	}
//
//	private Object given(Optional<Status> findById) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
