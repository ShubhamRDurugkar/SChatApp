package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table
@SequenceGenerator(name = "jobidseq", sequenceName="job_id_sequence", allocationSize = 1)
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobidseq")
	
	@Column(name = "jobId")
	private int jobId;
	
	@Column(name="jobDesignation")
	private String jobDesignation;
	
	@Column(name = "company")
    String company;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "jobDescription")
	private String jobDescription;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "lastDateToApply")
	private Date lastDateToApply;
	
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(Date lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}

	
}
