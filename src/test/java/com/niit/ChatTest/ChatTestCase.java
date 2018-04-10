package com.niit.ChatTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class ChatTestCase {

	private static BlogDAO blogDao;
	private Blog blog;
	//private BlogComment blogComment;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDAO) context.getBean("blogDAO");
	}

	@Ignore
	@Test
	public void test() {
		System.out.println("<----------config tested---------->");
		// fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void insertBlogTest() throws ParseException {

		blog = new Blog();
		blog.setBlogName("Shubham");
		blog.setLoginname("shubhamRD");
		blog.setBlogContent("Food blog");
		blog.setCreateDate(new Date());
		blog.setStatus("A");
		blog.setLikes(1);
		assertEquals("Successfully added blog into the table", true, blogDao.addBlog(blog));
		System.out.println("<-----------Successfully inserted into blog-------->");
	}


}
