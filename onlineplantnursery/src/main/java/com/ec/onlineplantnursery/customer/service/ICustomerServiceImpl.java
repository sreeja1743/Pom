package com.ec.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.requestDto.CustomerRequestDto;
import com.ec.onlineplantnursery.seed.entity.Seed;


@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository custRepo;
	
	public ICustomerServiceImpl() {
		super();
	}

	public ICustomerServiceImpl(ICustomerRepository custRepo) {
		super();
		this.custRepo = custRepo;
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		custRepo.save(customer);
		return customer;
	}
	
	
	@Override
	@Transactional
	public Customer updateCustomer(Customer tenant) throws ResourceNotFoundException{
		
		Optional<Customer> updatedCustomer = custRepo.findById(tenant.getCustomerId());

		if(updatedCustomer.isPresent()) {
			
			return custRepo.save(tenant);
		}
		else {
			throw new ResourceNotFoundException();
		}
	}

	
	@Transactional
	@Override
	public Customer deleteCustomer(Customer customer) throws ResourceNotFoundException{
		
		
		Optional<Customer> deletedCustomer = custRepo.findById(customer.getCustomerId());
		if(deletedCustomer.isPresent()) {
			custRepo.delete(customer);
		}
		else {
			
			throw new ResourceNotFoundException();
		}
		return deletedCustomer.get();
		
	}

	
	@Override
	public Customer viewCustomer(int customerId) throws ResourceNotFoundException {
		Optional<Customer> s = custRepo.findById(customerId);
	      if(s.isPresent()) {
	    	  return s.get();
	      }
	      else {
			
			throw new ResourceNotFoundException();
		}
	}

	
	@Override
	public List<Customer> viewAllCustomers() {
		return custRepo.findAll();
	}

	
	
	@Override
	public boolean validateCustomer(String userName, String password) {
		List<Customer> customers = custRepo.findByUserName(userName);
		for(Customer cust : customers) {
			if(cust.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
}
