package com.niit.jobTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;
import com.niit.model.Job;

public class DeleteJobTest {

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
	public void testDeleteJob() {
		job = jobDao.getJob(3);
		assertEquals("Successfully deleted job details from the table", true, jobDao.deleteJob(job));
		System.out.println("<-----------Successfully deleted job-------->");
	}
}
