package com.ec.onlineplantnursery.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.onlineplantnursery.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	//@Query("Select u from User u where u.userId=:username and u.password=:pass")
	Optional<User> findByUser(@Param("username") Integer username,@Param("pass") String pass);
}
