package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Service
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;


	   @Autowired
		public UserDAOImpl(SessionFactory sf) {
			super();
			this.sessionFactory = sf;
		}

	@Transactional
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public User getUser(int userId) {
		try {
			Session session = sessionFactory.openSession();
			User user = session.get(User.class, userId);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUser(String username) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<User> userList = new ArrayList<User>();
			Query query = session.createQuery("FROM User where username=:username").setString("username",username);
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

}
