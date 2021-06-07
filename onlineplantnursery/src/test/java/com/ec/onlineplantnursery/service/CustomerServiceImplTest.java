package com.ec.onlineplantnursery.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.onlineplantnursery.customer.entity.Address;
import com.ec.onlineplantnursery.customer.entity.Customer;

import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;
import com.ec.onlineplantnursery.customer.service.ICustomerServiceImpl;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;


@SpringBootTest
class CustomerServiceImplTest {


	ICustomerRepository customerRepo;
	
	@InjectMocks
	private static ICustomerServiceImpl customerService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	      customerRepo = mock(ICustomerRepository.class); // test through approach 2
	      customerService = new  ICustomerServiceImpl(customerRepo); 	// Approach 2
		  ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	@DisplayName("Test-Save Customer")
	void testSaveCustomer() {
		
		
		Customer input = new Customer();
		input.setCustomerId(1);
		input.setCustomerName("srividya");
		input.setCustomerEmail("vaddi.srividya0103@gmail.com");
		input.setUsername("srividya");
		input.setPassword("srividya0103");
		Address add = new Address();
		add.setAddressId(1);
		add.setCity("hyderabad");
		add.setColony("laxmi nagar");
        add.setHouseNo("12-1-508");
        add.setPincode(500017l);
        add.setState("Telangana");
        input.setAddress(add);
        
  
		when(customerRepo.save(input)).thenReturn(input);
		Customer custTest = customerService.addCustomer(input);
		assertEquals(input,custTest);
	}



	@Test
	@DisplayName("Test-Get All Customers")
	void testGetAllCustomers() {
		List<Customer> customerList = mock(List.class);
		when(customerRepo.findAll()).thenReturn(customerList);
		List<Customer> outputCustomerList = customerService.viewAllCustomers();
		//verify(customerRepo).findAll();
		assertEquals(customerList, outputCustomerList);
		
	}
	

	@Test
	@DisplayName("Test-Get Customer by Id")
	void testGetCustomerById() throws ResourceNotFoundException {
		int input = 101;
		Customer customer = mock(Customer.class);
		Optional<Customer> optional = Optional.of(customer);
		when(customerRepo.findById(input)).thenReturn(optional);
		Optional<Customer> output = Optional.of(customerService.viewCustomer(input));
		//verify(customerRepo).findById(input);
		assertEquals(optional, output);
	}
	

	@Test
	void testUpdateCustomer() throws ResourceNotFoundException { 
		
		Address address = new Address(20, "8-90", "Yusufguda", "Hyderabad", "Telangana", (long) 500045);
		Customer input = new Customer(1, "Srividya", "srividya123@gmail.com", "srividya2268", "123456", address);
		Optional<Customer> optional_customer = Optional.of(input);
		Customer savedCustomer = new Customer(1, "Srividya", "srividya0103@gmail.com", "srividya2268", "123456", address);
		when(customerRepo.findById(1)).thenReturn(optional_customer);
		when(customerRepo.save(savedCustomer)).thenReturn(savedCustomer);
		Customer outputCustomer = customerService.updateCustomer(savedCustomer);
		assertEquals(savedCustomer, outputCustomer);
	}
	

	@Test
	@DisplayName("Test-Delete seed")
	void testDeleteCustomer() throws ResourceNotFoundException {
		Customer input = new Customer();
		input.setCustomerId(1);
		input.setCustomerName("srividya");
		input.setCustomerEmail("vaddi.srividya0103@gmail.com");
		input.setUsername("srividya");
		input.setPassword("srividya0103");
		Address add = new Address();
		add.setAddressId(1);
		add.setCity("hyderabad");
		add.setColony("laxmi nagar");
        add.setHouseNo("12-1-508");
        add.setPincode(500017l);
        add.setState("Telangana");
        input.setAddress(add);
        
        
        Customer output = new Customer();
        output.setCustomerId(1);
        output.setCustomerName("srividya");
        output.setCustomerEmail("vaddi.srividya0103@gmail.com");
        output.setUsername("srividya");
        output.setPassword("srividya0103");
		Address add1 = new Address();
		add1.setAddressId(1);
		add1.setCity("hyderabad");
		add1.setColony("laxmi nagar");
        add1.setHouseNo("12-1-508");
        add1.setPincode(500017l);
        add1.setState("Telangana");
        output.setAddress(add1);
		
		
		try{
			doNothing().
			 when(customerRepo).delete(input);

			customerService.deleteCustomer(input);

			verify(customerRepo).delete(input);
			assertEquals(input,output);

		}
		catch(ResourceNotFoundException e) {
			
		}
		  
	}
	
	
	
	
}