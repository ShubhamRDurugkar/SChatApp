package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class GetForumTest {

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
	public void testGetForum() {
		forum = forumDao.getForum(21);
		assertEquals("Successfully fetched a forum details from the table", "99Dishes", forum.getForumName());
		System.out.println("<-----------Successfully fetched forum-------->");
	}
}
