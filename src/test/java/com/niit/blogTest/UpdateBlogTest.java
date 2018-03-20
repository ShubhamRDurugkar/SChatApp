package com.niit.blogTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class UpdateBlogTest {
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
	public void updateBlogTest() throws ParseException {
	
	    //blog =new Blog();
	    blog=blogDao.getBlog(15);
		blog.setBlogName("99Dishes");
		blog.setBlogContent("Helloo");
//		blog.setStatus("AP");
//		blog.setCreateDate(new Date());
//		blog.setUsername("ShubhamRDurugkar");
		assertEquals("Successfully updated blog into the table", true, blogDao.updateBlog(blog));
		System.out.println("<-----------Successfully updated blog-------->");
		

	}
}
