package com.journaldev.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.bean.Jobs;

@RestController
public class JobsJpaResources {
	
	@Autowired
	private JobsRepository jobsRepository;
	
	@GetMapping("/jpa/jobs")
	public List<Jobs> retrieveAllJobs(){
		return jobsRepository.findAll();
	}
	
	@GetMapping("/jpa/jobs/{id}")
	public Optional<Jobs> retrieveJobsById(@PathVariable int id) throws Exception{
		
		Optional<Jobs> job = jobsRepository.findById(id);
		
		if(!job.isPresent())
			throw new Exception("Job not present");
		else
			return job;
				
		
		
	}

}
