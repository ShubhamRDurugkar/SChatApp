package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetail;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail userDetail);
	public boolean checkLogin(UserDetail userDetail);
	public boolean updateOnlineStatus(String status,UserDetail userDetail);
	public UserDetail getUser(String loginname);
	
	public boolean deleteUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public List<UserDetail> listUsers();
}
