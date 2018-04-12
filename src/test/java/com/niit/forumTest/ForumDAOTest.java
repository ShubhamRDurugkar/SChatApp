package com.niit.forumTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

public class ForumDAOTest {
	private static ForumDAO forumDao;
	private Forum forum;
	private ForumComment forumComment;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	}

	@Ignore
	@Test
	public void insertForumTest() throws ParseException {

		forum = new Forum();
		forum.setForumName("Shubham");
		forum.setLoginname("shubhamRD");
		forum.setForumContent("Food Forum");
		forum.setCreatedDate(new Date());
		forum.setStatus("NA");
		assertEquals("Successfully added Forum into the table", true, forumDao.addForum(forum));

		System.out.println("<-----------Successfully inserted into Forum-------->");
	}

	@Ignore
	@Test
	public void updateForumTest() throws ParseException {

		forum = forumDao.getForum(1);
		forum.setForumName("99Dishes");
		forum.setForumContent("This is best place to visit..");
		forum.setStatus("AP");
		forum.setCreatedDate(new Date());
		forum.setLoginname("ShubhamRDurugkar");
		assertEquals("Successfully updated forum into the table", true, forumDao.updateForum(forum));
		System.out.println("<-----------Successfully updated forum-------->");
	}

	@Ignore
	@Test
	public void testGetForum() {
		forum = forumDao.getForum(1);
		assertEquals("Successfully fetched a forum details from the table", "99Dishes", forum.getForumName());
		System.out.println("<=========Forum fetched=======>");
		System.out.println("forumID :" + forum.getForumId());
		System.out.println("forumName :" + forum.getForumName());
		System.out.println("forumContent :" + forum.getForumContent());
		System.out.println("Username :" + forum.getLoginname());
		System.out.println("Status :" + forum.getStatus());
		System.out.println("Created Date :" + forum.getCreatedDate());
		System.out.println("<-----------Successfully fetched forum-------->");
	}

	@Ignore
	@Test
	public void testListForums() {
		List<Forum> listForums = forumDao.listForum("Shubham");
		assertTrue("Successfully fetched all forums from the table", forumDao.listForum("Shubham").size() > 0);
		System.out.println("<======List of Forum fetched======>");
		for (Forum forum : listForums) {
			System.out.println("forumID :" + forum.getForumId());
			System.out.println("forumName :" + forum.getForumName());
			System.out.println("forumContent :" + forum.getForumContent());
			System.out.println("Username :" + forum.getLoginname());
			System.out.println("Status :" + forum.getStatus());
			System.out.println("Created Date :" + forum.getCreatedDate());
		}
		System.out.println("<-----------Successfully retrieved list of forum-------->");
	}

	@Ignore
	@Test
	public void testDeleteForum() {
		forum = forumDao.getForum(2);
		assertEquals("Successfully deleted forum details from the table", true, forumDao.deleteForum(forum));
		System.out.println("<-----------Successfully deleted forum-------->");
	}

	@Ignore
	@Test
	public void testApproveForum() {
		forum = forumDao.getForum(3);
		String sts = forum.getStatus();
		if (sts.equals("NA")) {
			assertEquals("Successfully approved forum int the table", true, forumDao.approveForum(forum));
			System.out.println("<-----------Successfully approved forum-------->");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void testRejectForum() {
		forum = forumDao.getForum(3);
		String sts = forum.getStatus();
		if (sts.equals("A")) {
			assertEquals("Successfully approved forum int the table", true, forumDao.rejectForum(forum));
			System.out.println("<-----------Successfully rejected forum-------->");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void testAddForumComment() {
		forumComment = new ForumComment();
		forum = forumDao.getForum(1);
		String username = forum.getLoginname();
		int forumId = forum.getForumId();
		forumComment.setForumId(forumId);
		forumComment.setLoginname(username);
		forumComment.setCommentDate(new Date());
		forumComment.setCommentText("Destiny forum");
		assertEquals("Successfully added the forumComment...", true, forumDao.addForumComment(forumComment));
		System.out.println("<-----------Successfully added forumCommment-------->");
	}

	@Ignore
	@Test
	public void testGetForumCommment() {
		forumComment = forumDao.getForumComment(1);
		assertEquals("Successfully fetched a forumComments from the table", "ShubhamRDurugkar",
				forumComment.getLoginname());
		System.out.println("<========ForumComment========>");
		System.out.println("forumID :" + forumComment.getForumId());
		System.out.println("Username :" + forumComment.getLoginname());
		System.out.println("Status :" + forumComment.getCommmentID());
		System.out.println("Likes :" + forumComment.getCommentText());
		System.out.println("Created Date :" + forumComment.getCommentDate());
		System.out.println("<-----------Successfully fetched forumComment-------->");
	}

	@Ignore
	@Test
	public void testDeleteForumComment() {
		forumComment = forumDao.getForumComment(4);
		assertEquals("Successfully deleted forum details from the table", true,
				forumDao.deleteForumComment(forumComment));
		System.out.println("<-----------Successfully deleted forumComment-------->");
	}

	//@Ignore
	@Test
	public void testListForumComments() {
		List<ForumComment> listForumComments = forumDao.listForumComments(1);
		assertTrue("Successfully fetched all forums from the table", forumDao.listForumComments(1).size() > 0);
		System.out.println("<======ForumComments fetched======>");
		for (ForumComment forumComment : listForumComments) {
			System.out.println("forumID :" + forumComment.getForumId());
			System.out.println("CommentID :" + forumComment.getCommmentID());
			System.out.println("Comment Text :" + forumComment.getCommentText());
			System.out.println("Username :" + forumComment.getLoginname());
			System.out.println("Comment Date : " + forumComment.getCommentDate());
		}
		System.out.println("<-----------Successfully retrieved list of forumComments-------->");
	}

}
