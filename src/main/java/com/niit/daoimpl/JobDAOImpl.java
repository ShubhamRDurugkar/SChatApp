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

import com.niit.dao.JobDAO;
import com.niit.model.Job;

@Service
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;


	   @Autowired
		public JobDAOImpl(SessionFactory sf) {
			super();
			this.sessionFactory = sf;
		}

	@Transactional
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save (job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Job getJob(int jobId) {
		try {
			Session session = sessionFactory.openSession();
			Job job = session.get(Job.class, jobId);
			return job;
		} catch (Exception e) {
			return null;
		}
	}

	

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Job> listJob(int jobId) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Job> jobList = new ArrayList<Job>();
			Query query = session.createQuery("FROM Job where jobId=:jobId").setInteger("jobId",jobId);
			jobList = query.list();
			return jobList;
		} catch (Exception e) {
			return null;
		}
	}
}
