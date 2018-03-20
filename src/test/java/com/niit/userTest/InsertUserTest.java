package com.niit.userTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class InsertUserTest {

	private static UserDAO userDao;
	 private User user;

	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao = (UserDAO) context.getBean("userDAO");
	}
	@Test
	public void insertUserTest() throws ParseException {
		
	    user =new User();
		user.setUsername("shubhamRD");
		user.setEmailId("shubham341.rd@gmail.com");
		user.setFirstname("Shubham");
		user.setLastname("Durugkar");
		user.setPassword("asdf");
		user.setEnabled(true);
		user.setStatus("Approved");
		user.setRole("ROLE_USER");
		user.setGender('M');
		user.setBirthDate(new Date());
		assertEquals("Successfully added User into the table", true, userDao.addUser(user));
		
		System.out.println("<-----------Successfully inserted into User-------->");
	}
}
