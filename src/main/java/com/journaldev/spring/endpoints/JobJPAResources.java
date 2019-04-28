package com.journaldev.spring.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.bean.Jobs;
import com.journaldev.spring.daoservice.JobJPAService;
import com.journaldev.spring.daoservice.JobsRepository;
import com.journaldev.spring.exception.UserNotFoundException;

@RestController
public class JobJPAResources {
	
	
	@Autowired
	private JobsRepository repository;
	
	
	
	@GetMapping("/jpa/jobs")
	public List<Jobs> retrieveJobs() {
		return repository.findAll();
		
	}
	
	@GetMapping("/jpa/jobs/{id}")
	public Optional<Jobs> retrieveJob(@PathVariable int id) {
		
		Optional<Jobs> job = repository.findById(id);
		if(!job.isPresent()) {
			throw new UserNotFoundException("id "+id);
		}
		
		return job;
	}
	
	
	
	
	
	
	

}
