package com.ec.onlineplantnursery.customer.repository;

import java.util.List;

import com.ec.onlineplantnursery.customer.entity.Customer;

public interface CustomCustomerRepository {

	public List<Customer> findByUserName(String username);
}
