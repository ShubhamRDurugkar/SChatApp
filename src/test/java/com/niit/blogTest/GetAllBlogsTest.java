package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;

public class GetAllBlogsTest {
	private static BlogDAO blogDao;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void testDeleteBlog() {
		assertEquals("Successfully fetched all blogs from the table", 2,
				blogDao.listBlog("shubhamRD").size());

		System.out.println("<-----------Successfully retrieved list of blog-------->");
	}
}
