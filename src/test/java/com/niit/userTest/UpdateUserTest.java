package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UpdateUserTest {

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
	public void updateUserTest() throws ParseException {
		
		 user =new User();
		user = userDao.getUser(1);
		 user.setBirthDate(new Date());
		 user.setUsername("ShubhamRDurugkar");
		assertEquals("Successfully updated user into the table", true, userDao.updateUser(user));
		System.out.println("<-----------Successfully updated user-------->");
	}
}
