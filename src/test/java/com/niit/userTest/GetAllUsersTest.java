package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;

public class GetAllUsersTest {

	private static UserDAO userDao;

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
		assertEquals("Successfully fetched all users from the table", 1,
				userDao.listUser("ShubhamRDurugkar").size());

		System.out.println("<-----------Successfully retrieved list of user-------->");
	}
}
