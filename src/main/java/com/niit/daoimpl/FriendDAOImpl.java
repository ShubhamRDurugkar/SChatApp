package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.UserDetail;

@Repository(value = "friendDAO")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	@Transactional
	@Override
	public boolean sendFriendRequest(Friend friend) {
		try {
			System.out.println("Into sendFriendRequest");
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteFriendRequest(int friendId) {
		try {
			System.out.println("Into deleteFriendRequest");
			Session session = sessionFactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);
			if(friend.getStatus()=="P"){
			sessionFactory.getCurrentSession().delete(friend);
			session.close();
			System.out.println("Deleted friendRequest of id : " + friendId);
			}
			else{
				System.out.println("Friend request already accepted..!!");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetail> showSuggestedFriend(String loginname) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery("select * from userdetail where loginname not in (select friendloginname from friend)");
		List<UserDetail> suggestFriend = (List<UserDetail>) query.list();
		return suggestFriend;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> showAllFriends(String loginname) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where loginname =:currentuser and status='A')");
		query.setParameter("currentuser", loginname);
		List<Friend> listFriends = (List<Friend>) query.list();
		return listFriends;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> showRequestPendingList(String loginname) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where loginname =:currentuser and status='P')");
		query.setParameter("currentuser", loginname);
		List<Friend> listFriends = (List<Friend>) query.list();
		return listFriends;
	}

	@Transactional
	@Override
	public boolean acceptFriendRequest(int friendId) {
		try {
			Session session = sessionFactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
