package com.niit.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;
@Service
@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sessionFactory;


	   @Autowired
		public ForumDAOImpl(SessionFactory sf) {
			super();
			this.sessionFactory = sf;
		}

	@Transactional
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Forum getForum(int forumId) {
		try {
			Session session = sessionFactory.openSession();
			Forum forum = session.get(Forum.class, forumId);
			return forum;
		} catch (Exception e) {
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Forum> listForum(String username) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Forum> forumList = new ArrayList<Forum>();
			Query query = session.createQuery("FROM Forum where username=:username").setString("username",username);
			forumList = query.list();
			return forumList;
		} catch (Exception e) {
			return null;
		}
	}

}
