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
import com.niit.model.ForumComment;

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
			System.out.println("in update forum dao");
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
	public List<Forum> listForum(String loginname) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Forum> forumList = new ArrayList<Forum>();
			Query query = session.createQuery("FROM Forum where loginname=:loginname");
			query.setParameter("loginname", loginname);
			forumList = query.list();
			return forumList;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	@Override
	public boolean addForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ForumComment getForumComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			ForumComment forumComment = session.get(ForumComment.class, commentId);
			return forumComment;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public List<ForumComment> listForumComments(int forumId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId", new Integer(forumId));
		@SuppressWarnings("unchecked")
		List<ForumComment> listForumComments = query.list();
		return listForumComments;
	}

}
