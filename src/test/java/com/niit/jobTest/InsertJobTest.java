package com.niit.jobTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class InsertJobTest {

	private static JobDAO jobDao;
	 private Job job;

	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDAO) context.getBean("jobDAO");
	}
	@Test
	public void insertJobTest() throws ParseException {
		
	    job =new Job();
		job.setJobTitle("Trainee Er");
		job.setJobDescription("Applied for trainee engineer.");
		job.setPostedDate(new Date());
		job.setSalary("3LPA");
		job.setDesgination("Developer");
		assertEquals("Successfully added job into the table", true, jobDao.addJob(job));
		
		System.out.println("<-----------Successfully inserted into job-------->");
	}

}
