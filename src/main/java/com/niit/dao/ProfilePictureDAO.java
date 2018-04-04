package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDAO {

	public void insertOrUpdateProfilePicture(ProfilePicture profilePicture);

	public ProfilePicture getProfilePicture(String loginname);

}