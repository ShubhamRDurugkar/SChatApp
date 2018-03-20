package com.niit.jobTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class UpdateJobTest {

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
	public void updateJobTest() throws ParseException {
	
	    //job =new Job();
	    job=jobDao.getJob(3);
		job.setJobTitle("AssociateER");
		job.setJobDescription("Associate engineer for core java advance java");
//		job.setStatus("AP");
//		job.setCreateDate(new Date());
//		job.setUsername("ShubhamRDurugkar");
		assertEquals("Successfully updated job into the table", true, jobDao.updateJob(job));
		System.out.println("<-----------Successfully updated job-------->");
	}
}
