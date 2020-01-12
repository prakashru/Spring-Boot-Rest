package com.journaldev.spring.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.bean.Jobs;
@Repository
public interface JobsRepository  extends JpaRepository<Jobs, Integer> {
	
	

}
