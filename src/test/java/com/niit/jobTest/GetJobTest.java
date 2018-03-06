package com.niit.jobTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class GetJobTest {

	private static JobDAO jobDao;
	private Job job;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDAO) context.getBean("jobDAO");
	}

	@Test
	public void testGetJob() {
		job = jobDao.getJob(3);
		assertEquals("Successfully fetched a job details from the table", "AssociateER", job.getJobTitle());
		System.out.println("<-----------Successfully fetched job-------->");
	}
}
