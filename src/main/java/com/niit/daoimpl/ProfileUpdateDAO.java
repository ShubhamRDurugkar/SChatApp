package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProfilePicture;

@Repository("profileUpdateDAO")
@Transactional
public class ProfileUpdateDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public ProfileUpdateDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(ProfilePicture profilePicture)
	{
		System.out.println("Profile Loginname : "+profilePicture.getLoginname());
		Session session=sessionFactory.openSession();
		session.save(profilePicture);
		session.flush();
		session.close();
	}
	
	public ProfilePicture getProfilePicture(String loginname)
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,loginname);
		session.close();
		return profilePicture;
	}

}