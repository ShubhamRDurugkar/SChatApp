package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class GetBlogTest {

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
	public void testGetBlog() {
		blog = blogDao.getBlog(15);
		assertEquals("Successfully fetched a blog details from the table", "99Dishes", blog.getBlogName());
		System.out.println("<-----------Successfully fetched blog-------->");
	}

}
