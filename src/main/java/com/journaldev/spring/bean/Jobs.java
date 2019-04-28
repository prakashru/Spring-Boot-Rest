package com.journaldev.spring.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Jobs {
	
	@Id
	@GeneratedValue
	private Integer jobId;
	private String jobName;
	private String jobDetails;
	private String jobStatus;
	
	
	protected Jobs() {
		
	}
	
	
	
	
	public Jobs(Integer jobId, String jobName, String jobDetails, String jobStatus) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDetails = jobDetails;
		this.jobStatus = jobStatus;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	
	
	

}
