package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class RejectBlogTest {
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
	public void testRejectBlog() {
		blog = blogDao.getBlog(19);
		String sts = blog.getStatus();
		if (sts.equals("APPROVED")) {
			assertEquals("Successfully approved blog int the table", true, blogDao.rejectBlog(blog));
			System.out.println("<-----------Successfully rejected blog-------->");
		} else {
			System.out.println("not approved");
		}
	}
}
