package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProfileUpdateDAO;
import com.niit.model.ProfilePicture;

@Service
@Repository("profileUpdateDAO")
public class ProfileUpdateDAOImpl implements ProfileUpdateDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public ProfileUpdateDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void save(ProfilePicture profilePicture) {
		System.out.println("Profile Loginname : " + profilePicture.getLoginname());
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
	}

	@Override
	@Transactional
	public ProfilePicture getProfilePicture(String loginname) {
		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, loginname);
		session.close();
		return profilePicture;
	}

}