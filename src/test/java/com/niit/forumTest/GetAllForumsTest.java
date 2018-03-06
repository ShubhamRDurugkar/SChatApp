package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;

public class GetAllForumsTest {

	private static ForumDAO forumDao;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void testDeleteForum() {
		assertEquals("Successfully fetched all forums from the table", 1,
				forumDao.listForum("shubhamRD").size());

		System.out.println("<-----------Successfully retrieved list of forum-------->");
	}
}
