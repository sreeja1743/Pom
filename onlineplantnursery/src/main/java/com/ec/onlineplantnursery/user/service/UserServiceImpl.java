package com.ec.onlineplantnursery.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;
import com.ec.onlineplantnursery.user.User;
import com.ec.onlineplantnursery.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
     UserRepository userRepo;
   
     
	@Override
	@Transactional
	public User addNewUser(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public User signIn(User user) throws InvalidCredentialException {
		

			int username=user.getUserId();
			String pass=user.getPassword();  
		
			Optional<User>opt = userRepo.findByUser(username, pass);
	    if(!(opt.isPresent())){
			throw new InvalidCredentialException("Autorization failed! user not found in signin");

		}

		return opt.get();
	}

	@Override
	public User signOut(User user) {

		return null;
	}

}
