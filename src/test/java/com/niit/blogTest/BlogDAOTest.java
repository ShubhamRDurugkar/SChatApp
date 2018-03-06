package com.niit.blogTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogDAOTest {

	
	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	}
	@Test
	public void test(){
		System.out.println("config tested---------->");
		//fail("Not yet implemented");
	}
}
