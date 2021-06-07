package com.ec.onlineplantnursery.user.service;

import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;
import com.ec.onlineplantnursery.user.User;

public interface UserService {
	
	public  User addNewUser(User user);
	public User signIn(User user) throws InvalidCredentialException;
	public User signOut(User user);



}
