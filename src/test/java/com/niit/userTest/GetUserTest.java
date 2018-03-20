package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class GetUserTest {

	private static UserDAO userDao;
	private User user;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testGetUser() {
		user = userDao.getUser(3);
		assertEquals("Successfully fetched a user details from the table", "ShubhamRDurugkar", user.getUsername());
		System.out.println("<-----------Successfully fetched user-------->");
	}
}
