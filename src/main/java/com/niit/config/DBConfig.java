package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.daoimpl.BlogDAOImpl;
import com.niit.daoimpl.ForumDAOImpl;
import com.niit.daoimpl.FriendDAOImpl;
import com.niit.daoimpl.JobDAOImpl;
import com.niit.daoimpl.ProfileUpdateDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.ApplyJob;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.Message;
import com.niit.model.ProfilePicture;
import com.niit.model.UserDetail;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {

	// DATA SOURCE OBJECT
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("password");
		return dataSource;
	}

	// Created Bean SessionFactory
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();

		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder sessionFactoryBuiler = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuiler.addProperties(hibernateProp);
		System.out.println("<-----------Hibernate properties added---------------->");
		sessionFactoryBuiler.addAnnotatedClass(Blog.class);
		System.out.println("<--------------Blog Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(BlogComment.class);
		System.out.println("<--------------BlogComment Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(Forum.class);
		System.out.println("<--------------Forum Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(ForumComment.class);
		System.out.println("<--------------ForumComment Class Added-------------->");

		sessionFactoryBuiler.addAnnotatedClass(Job.class);
		System.out.println("<--------------Job Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(ApplyJob.class);
		System.out.println("<--------------ApplyJob Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(ProfilePicture.class);
		System.out.println("<--------------ProfilePicture Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(Message.class);
		System.out.println("<--------------Messagse Class Added-------------->");
		sessionFactoryBuiler.addAnnotatedClass(Friend.class);
		System.out.println("<--------------Friend Class Added-------------->");

		sessionFactoryBuiler.addAnnotatedClass(UserDetail.class);
		System.out.println("<--------------UserDetails Class Added-------------->");
		SessionFactory sessionFactory = sessionFactoryBuiler.buildSessionFactory();
		System.out.println("<---------Session object created--------->");
		return sessionFactory;

	}

	@Bean(name = "blogDAOImpl")
	public BlogDAOImpl getBlogDAO(SessionFactory sf) {
		return new BlogDAOImpl(sf);
	}

	@Bean(name = "forumDAOImpl")
	public ForumDAOImpl getForumDAO(SessionFactory sf) {
		return new ForumDAOImpl(sf);
	}

	@Bean(name = "jobDAOImpl")
	public JobDAOImpl getJobgDAO(SessionFactory sf) {
		return new JobDAOImpl(sf);
	}

	@Bean(name = "userDAOImpl")
	public UserDAOImpl getUserDAO(SessionFactory sf) {
		return new UserDAOImpl(sf);
	}

	@Bean(name = "profileUpdateDAOImpl")
	public ProfileUpdateDAOImpl getProfilePictureDAO(SessionFactory sf) {
		return new ProfileUpdateDAOImpl(sf);
	}

	@Bean(name = "friendDAOImpl")
	public FriendDAOImpl getFriendDAO(SessionFactory sf) {
		return new FriendDAOImpl(sf);
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
}
