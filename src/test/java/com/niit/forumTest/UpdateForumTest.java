package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class UpdateForumTest {

	private static ForumDAO forumDao;
	private Forum forum;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void updateForumTest() throws ParseException {
		// SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		// forum =new Forum();
		forum = forumDao.getForum(21);
		forum.setForumName("99Dishes");
		forum.setForumContent("Helloo");
		// forum.setStatus("AP");
		// forum.setCreateDate(textFormat.parse("2017-06-18"));
		// forum.setUsername("ShubhamRDurugkar");
		assertEquals("Successfully updated forum into the table", true, forumDao.updateForum(forum));
		System.out.println("<-----------Successfully updated forum-------->");
	}
}
