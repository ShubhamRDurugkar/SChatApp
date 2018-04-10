package com.niit.FriendTest ;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.UserDetail;

public class FriendDAOTest {
	private static FriendDAO friendDao;
	private Friend friend;
	

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDao = (FriendDAO) context.getBean("friendDAO");
	}

	@Ignore
	@Test
	public void sendFriendRequestTest() {
		friend=new Friend();
		friend.setFriendloginname("SAchin");
		friend.setLoginname("Akshay");	
		assertTrue("Problem in sending friend request",friendDao.sendFriendRequest(friend));
		System.out.println("<===================Friend Request sent======================>");
		System.out.println("FirendID:"+friend.getFriendId());
		System.out.println("FriendLoginname :"+friend.getFriendloginname());
		System.out.println("Loginname :"+friend.getLoginname());
		System.out.println("Status :"+friend.getStatus());
	}
	@Ignore
	@Test
	public void deleteFriendRequest(){
		assertTrue("Problem in deleting friend request",friendDao.deleteFriendRequest(1));
		System.out.println("<====================Friend Request deleted==========================>");
	}
	@Ignore
	@Test
	public void showPendingFriendRequestTest()
	{
		 List<Friend> listFriendReqPending =friendDao.showRequestPendingList("Shubham");
		 assertNotNull("Problem found null pointer",listFriendReqPending);
		System.out.println("<========================Pending friend requests=====================>");
		 for(Friend friend:listFriendReqPending){
			 System.out.println(friend.getLoginname()+"::::"+friend.getFriendloginname());
		 }
	}
	
	@Ignore
	@Test
	public void showSuggestedFriendTest()
	{
		 List<UserDetail> listSuggestedFriends =friendDao.showSuggestedFriend("SachinB");
		 assertNotNull("Problem found null pointer",listSuggestedFriends);
			System.out.println("<========================Suggested friends=====================>");
		 for(UserDetail userDetail:listSuggestedFriends){
			 System.out.println(userDetail.getLoginname());
		 }
	}
	@Ignore
	@Test
	public void showAllFriendRequestsTest()
	{
		 List<Friend> listFriendRequests =friendDao.showAllFriends("Shubham");
		 assertNotNull("Problem found null pointer",listFriendRequests);
		System.out.println("<========================All friend requests=====================>");
		 for(Friend friend:listFriendRequests){
			 System.out.println(friend.getLoginname()+"::::"+friend.getFriendloginname());
		 }	
	}
	@Ignore
	@Test
	public void acceptFriendRequestTest()
	{
		assertTrue("Problem in accepting the friend request..",friendDao.acceptFriendRequest(4));
		System.out.println("<========================Friend request accepted=====================>");
		
	}
	
}
