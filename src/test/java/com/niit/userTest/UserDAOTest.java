package com.niit.userTest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDAOTest {

	static UserDetailDAO userDetailDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialze() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailDAO = (UserDetailDAO) context.getBean("userDAO");
	}

	@Ignore
	@Test
	public void registerUserTest() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginname("Shubham");
		userDetail.setPassword("asdf");
		userDetail.setRole("ROLE_USER");
		userDetail.setUsername("Shubham Durugkar");
		userDetail.setAddress("Latur");
		userDetail.setIsOnline("N");
		userDetail.setMobileNo("9884442227");
		userDetail.setEmailId("srd@gmail.com");
		assertTrue("Problem in insertion", userDetailDAO.registerUser(userDetail));
	System.out.println("<============Successfully registered the User==================>");
	}
	@Ignore
	@Test
	public void updateInlineStatusTest(){
		UserDetail userDetail=userDetailDAO.getUser("Shubham");
		assertTrue("Problem in updating status",userDetailDAO.updateOnlineStatus("Y", userDetail));
		System.out.println("<============Updated the online status============>");
	}
	//@Ignore
	@Test
	public void checkUserTest(){
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("Shubham");
		userDetail.setPassword("asdf");
		assertTrue("Check user failed",userDetailDAO.checkLogin(userDetail));
		System.out.println("<=================Checked user successfully=============>");
	}
	
}
