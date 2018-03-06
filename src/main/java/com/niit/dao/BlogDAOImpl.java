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

import com.niit.model.Blog;
@Service
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;


	   @Autowired
		public BlogDAOImpl(SessionFactory sf) {
			super();
			this.sessionFactory = sf;
		}

	@Transactional
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Blog getBlog(int blogId) {
		try {
			Session session = sessionFactory.openSession();
			Blog blog = session.get(Blog.class, blogId);
			return blog;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("APPROVED");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> listBlog(String username) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Blog> blogList = new ArrayList<Blog>();
			Query query = session.createQuery("FROM Blog where username=:username").setString("username",username);
			blogList = query.list();
			return blogList;
		} catch (Exception e) {
			return null;
		}
	}

}
