package com.journaldev.spring.daoservice;

import com.journaldev.spring.bean.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JobsRepository 
extends JpaRepository<Jobs, Integer> {
	

}
