package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class DeleteBlogTest {
	private static BlogDAO blogDao;
	private Blog blog;

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
		blog = blogDao.getBlog(1);
		assertEquals("Successfully deleted blog details from the table", true, blogDao.deleteBlog(blog));
		System.out.println("<-----------Successfully deleted blog-------->");
	}
}
