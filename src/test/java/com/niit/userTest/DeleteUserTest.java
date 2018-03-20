package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class DeleteUserTest {

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
	public void testDeleteUser() {
		user = userDao.getUser(3);
		assertEquals("Successfully deleted user details from the table", true, userDao.deleteUser(user));
		System.out.println("<-----------Successfully deleted user-------->");
	}
}
