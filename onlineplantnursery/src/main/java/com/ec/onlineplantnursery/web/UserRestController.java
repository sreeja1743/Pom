package com.ec.onlineplantnursery.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;
import com.ec.onlineplantnursery.user.User;
import com.ec.onlineplantnursery.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	UserService userservice;
	@PostMapping("/add")
	public User adduser(@RequestBody @Valid User user)
	{
		this.userservice.addNewUser(user);
		return user;
	}
	@PostMapping("/signin")
	public User signuser(@RequestBody @Valid User user) throws InvalidCredentialException
	{
		this.userservice.signIn(user);
		return user;
	}
	@PostMapping("/signout")
	public User signoutuser(@RequestBody @Valid User user) 
	{
		this.userservice.signOut(user);
		return user;
	}
}
