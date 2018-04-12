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

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

@Service
@Repository("userDAO")
public class UserDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	@Transactional
	public boolean registerUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDetail> listUsers() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<UserDetail> userList = new ArrayList<UserDetail>();
			Query query = session.createQuery("FROM User");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public boolean checkLogin(UserDetail userDetail) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetail where loginname=:loginname and password=:password");
			query.setParameter("loginname",userDetail.getLoginname());
			query.setParameter("password",userDetail.getPassword());
			UserDetail userDetails=(UserDetail)query.list().get(0);
			session.close();
			if(userDetails==null){
				return false;
			}else
			{
			 return true;
			}
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateOnlineStatus(String status, UserDetail userDetail) {
		try {
			userDetail.setIsOnline(status);
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public UserDetail getUser(String loginname) {
		try {
			Session session = sessionFactory.openSession();
			UserDetail userDetails = session.get(UserDetail.class, loginname);
			return userDetails;
		} catch (Exception e) {
			return null;
		}
	}
	

}
