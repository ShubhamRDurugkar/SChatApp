package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.UserDetail;

public interface FriendDAO {

	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public List<UserDetail> showSuggestedFriend(String loginname);
	public List<Friend> showAllFriends(String loginname);
	public List<Friend> showRequestPendingList(String loginname);
	public boolean acceptFriendRequest(int friendId);
}
