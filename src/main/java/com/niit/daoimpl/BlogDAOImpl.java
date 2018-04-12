package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
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
			blog.setStatus("A");
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
	public List<Blog> listBlog(String loginname) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM Blog where loginname=:loginname");
			query.setParameter("loginname",loginname);
			List<Blog> blogList = query.list();
			session.close();
			return blogList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean incrementLike(Blog blog) {
	 try{
		 int likes=blog.getLikes();
		 likes++;
		 blog.setLikes(likes);
		 sessionFactory.getCurrentSession().update(blog);
		 return true;
	 }catch(Exception e)
	 {
		 return false;
	 }
	}

	@Override
	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public BlogComment getBlogComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class,commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	@Transactional
	public List<BlogComment> listBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogId));
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}

}
