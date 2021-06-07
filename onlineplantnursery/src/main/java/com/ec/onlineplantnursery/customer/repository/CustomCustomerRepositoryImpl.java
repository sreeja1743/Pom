package com.ec.onlineplantnursery.customer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;


import com.ec.onlineplantnursery.customer.entity.Customer;

public class CustomCustomerRepositoryImpl implements CustomCustomerRepository{

	@Autowired
	EntityManager entityManager;
    
	@Override
	public List<Customer> findByUserName(String username) {
		Query q = entityManager.createQuery("from Customer where username := username");
		q.setParameter("userName", "userName");
		return q.getResultList();
	}

}
