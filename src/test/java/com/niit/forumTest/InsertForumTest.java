package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class InsertForumTest {
	private static ForumDAO forumDao;
	 private Forum forum;

	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	}
	@Test
	public void insertForumTest() throws ParseException {
		
	    forum =new Forum();
		forum.setForumName("Shubham");
		forum.setUsername("shubhamRD");
		forum.setForumContent("Food Forum");
		forum.setCreatedDate(new Date());
		//forum.setStatus("NA");
		assertEquals("Successfully added Forum into the table", true, forumDao.addForum(forum));
		
		System.out.println("<-----------Successfully inserted into Forum-------->");
	}

}
