package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
	    forum =new Forum();
		forum.setForumName("Shubham");
		forum.setUsername("shubhamRD");
		forum.setForumContent("Food Forum");
		forum.setCreatedDate(textFormat.parse("2017-06-18"));
		//forum.setStatus("NA");
		assertEquals("Successfully added Forum into the table", true, forumDao.addForum(forum));
		
		System.out.println("<-----------Successfully inserted into Forum-------->");
	}

}
