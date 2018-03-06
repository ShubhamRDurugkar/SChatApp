package com.niit.forumTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class DeleteForumTest {

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
	public void testDeleteForum() {
		forum = forumDao.getForum(21);
		assertEquals("Successfully deleted forum details from the table", true, forumDao.deleteForum(forum));
		System.out.println("<-----------Successfully deleted forum-------->");
	}
}
