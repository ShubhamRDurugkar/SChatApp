package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class InsertBlogTest {

	private static BlogDAO blogDao;
	 private Blog blog;

	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDAO) context.getBean("blogDAO");
	}
	@Test
	public void insertBlogTest() throws ParseException {
		
	    blog =new Blog();
		blog.setBlogName("Shubham");
		blog.setUsername("shubhamRD");
		blog.setBlogContent("Food blog");
		blog.setCreateDate(new Date());
		blog.setStatus("NA");
		assertEquals("Successfully added blog into the table", true, blogDao.addBlog(blog));
		
		System.out.println("<-----------Successfully inserted into blog-------->");
	}

}
