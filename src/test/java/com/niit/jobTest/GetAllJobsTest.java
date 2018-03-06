package com.niit.jobTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;

public class GetAllJobsTest {

	private static JobDAO jobDao;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDAO) context.getBean("jobDAO");
	}

	@Test
	public void testGetAllJob() {
		assertEquals("Successfully fetched all jobs from the table", 1,
				jobDao.listJob(3).size());

		System.out.println("<-----------Successfully retrieved list of job-------->");
	}
}
