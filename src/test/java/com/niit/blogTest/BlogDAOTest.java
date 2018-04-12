package com.niit.blogTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogDAOTest {

	private static BlogDAO blogDao;
	private Blog blog;
	private BlogComment blogComment;

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

	@Ignore
	@Test
	public void updateBlogTest() throws ParseException {

		blog = new Blog();
		blog = blogDao.getBlog(1);
		blog.setBlogName("99Dishes");
		blog.setBlogContent("Helloo");
		assertEquals("Successfully updated blog into the table", true, blogDao.updateBlog(blog));
		System.out.println("<-----------Successfully updated blog-------->");

	}

	@Ignore
	@Test
	public void testGetBlog() {
		blog = blogDao.getBlog(1);
		assertEquals("Successfully fetched a blog details from the table", "Shubham", blog.getBlogName());
		System.out.println("<=========Blog fetched=======>");
		System.out.println("blogID :" + blog.getBlogId());
		System.out.println("blogName :" + blog.getBlogName());
		System.out.println("blogContent :" + blog.getBlogContent());
		System.out.println("Username :" + blog.getLoginname());
		System.out.println("Status :" + blog.getStatus());
		System.out.println("Likes :" + blog.getLikes());
		System.out.println("Created Date :" + blog.getCreateDate());
		System.out.println("<-----------Successfully fetched blog-------->");
	}

	@Ignore
	@Test
	public void testListBlog() {
		List<Blog> listBlogs = blogDao.listBlog("Shubham");
		assertTrue("Successfully fetched all blogs from the table", blogDao.listBlog("Shubham").size() > 0);
		System.out.println("<======List of Blog fetched======>");
		for (Blog blog : listBlogs) {
			System.out.println("blogID :" + blog.getBlogId());
			System.out.println("blogName :" + blog.getBlogName());
			System.out.println("blogContent :" + blog.getBlogContent());
			System.out.println("Username :" + blog.getLoginname());
			System.out.println("Status :" + blog.getStatus());
			System.out.println("Likes :" + blog.getLikes());
			System.out.println("Created Date :" + blog.getCreateDate());
		}
		System.out.println("<-----------Successfully retrieved list of blog-------->");
	}

	@Ignore
	@Test
	public void testDeleteBlog() {
		blog = blogDao.getBlog(1);
		assertEquals("Successfully deleted blog details from the table", true, blogDao.deleteBlog(blog));
		System.out.println("<-----------Successfully deleted blog-------->");
	}

	@Ignore
	@Test
	public void testApproveBlog() {
		blog = blogDao.getBlog(3);
		String sts = blog.getStatus();
		if (sts.equals("NA")) {
			assertEquals("Successfully approved blog int the table", true, blogDao.approveBlog(blog));
			System.out.println("<-----------Successfully approved blog-------->");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void testRejectBlog() {
		blog = blogDao.getBlog(3);
		String sts = blog.getStatus();
		if (sts.equals("A")) {
			assertEquals("Successfully approved blog int the table", true, blogDao.rejectBlog(blog));
			System.out.println("<-----------Successfully rejected blog-------->");
		} else {
			System.out.println("not approved");
		}
	}

	@Test
	public void testIncrementLikes() {
		blog = blogDao.getBlog(1);
		assertEquals("Successfully incremented likes to the table", true, blogDao.incrementLike(blog));
		System.out.println("<=========Likes=========>");
		System.out.println("Likes After incrementing :" + blog.getLikes());
		System.out.println("<-----------Successfully incremented blog likes-------->");
	}

	@Ignore
	@Test
	public void testAddBlogComment() {
		blogComment = new BlogComment();
		blog = blogDao.getBlog(1);
		String username = blog.getLoginname();
		int blogId = blog.getBlogId();
		blogComment.setBlogId(blogId);
		blogComment.setUsername(username);
		blogComment.setCommentDate(new Date());
		blogComment.setCommentText("Hibernate blog");
		assertEquals("Successfully added the blogComment...", true, blogDao.addBlogComment(blogComment));
		System.out.println("<-----------Successfully added blogCommment-------->");
	}

	@Ignore
	@Test
	public void testGetBlogCommment() {
		blogComment = blogDao.getBlogComment(1);
		assertEquals("Successfully fetched a blogComments from the table", "shubhamRD", blogComment.getUsername());
		System.out.println("<========BlogComment========>");
		System.out.println("blogID :" + blogComment.getBlogId());
		System.out.println("Username :" + blogComment.getUsername());
		System.out.println("Status :" + blogComment.getCommmentID());
		System.out.println("Likes :" + blogComment.getCommentText());
		System.out.println("Created Date :" + blogComment.getCommentDate());
		System.out.println("<-----------Successfully fetched blogComment-------->");
	}

	//@Ignore
	@Test
	public void testDeleteBlogComment() {
		blogComment = blogDao.getBlogComment(5);
		assertEquals("Successfully deleted blog details from the table", true, blogDao.deleteBlogComment(blogComment));
		System.out.println("<-----------Successfully deleted blogComment-------->");
	}

	// @Ignore
	@Test
	public void testListBlogComments() {
		List<BlogComment> listBlogComments = blogDao.listBlogComments(1);
		assertTrue("Successfully fetched all blogs from the table", blogDao.listBlogComments(1).size() > 0);
		System.out.println("<======BlogComments fetched======>");
		for (BlogComment blogComment : listBlogComments) {
			System.out.println("blogID :" + blogComment.getBlogId());
			System.out.println("CommentID :" + blogComment.getCommmentID());
			System.out.println("Comment Text :" + blogComment.getCommentText());
			System.out.println("Username :" + blogComment.getUsername());
			System.out.println("Comment Date : " + blogComment.getCommentDate());
		}
		System.out.println("<-----------Successfully retrieved list of blogComments-------->");
	}

}
