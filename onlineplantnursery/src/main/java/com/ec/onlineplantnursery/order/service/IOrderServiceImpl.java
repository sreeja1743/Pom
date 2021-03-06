package com.ec.onlineplantnursery.order.service;



import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;


import com.ec.onlineplantnursery.customer.repository.ICustomerRepository;

import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.repository.IOrderRepository;

import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.repository.IPlanterRepository;


@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRep;
	

	public IOrderServiceImpl() {
		super();
	}


	public IOrderServiceImpl(IOrderRepository orderRep) {
		super();
		this.orderRep = orderRep;
	}

	
	/*Method Name:addOrder
	 *Parameters:Order
	 *ReturnType:Optional<Order>
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */

	@Override
	public Order addOrder(Order order) throws ResourceNotFoundException {
		try {
		double totalBill = 0;
		List<Planter> planters = order.getPlanters();
		for(Planter p : planters) {
			if(p.getPlant() != null) {
				totalBill = orderRep.totalCost(p.getPlanterId());
			}
		}
		
		order.setTotalCost(totalBill);
		orderRep.save(order);
		return order;
	}
		catch(Exception e) {
			throw new ResourceNotFoundException();
		}
	}

	
	/*Method Name:updateOrder
	 *Parameters:Order
	 *ReturnType:Order
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */ 
	
	@Override
	@Transactional
	public Order updateOrder(Order order) throws ResourceNotFoundException {
		

		Optional<Order> op = orderRep.findById(order.getBookingOrderId());

		if (op.isPresent()) {
			
			op.get().setOrderDate(order.getOrderDate());
			op.get().setQuantity(order.getQuantity());
			op.get().setTotalCost(order.getTotalCost());
			op.get().setTransactionMode(order.getTransactionMode());
			return orderRep.save(op.get());
			
	}
		else {
			throw new ResourceNotFoundException();
		}
		
	}
	
	/*Method Name:deleteOrder
	 *Parameters:orderId
	 *ReturnType:Order
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */

	@Override
	public Order deleteOrder(int orderId) throws ResourceNotFoundException {

		Optional<Order> o = orderRep.findById(orderId);
		if(o.isPresent()) {
		
		 orderRep.deleteById(orderId);
		 System.out.println(o.get());
		 return o.get();
		}
		else {
			throw new ResourceNotFoundException();
		}
		
	}

	/*Method Name:viewOrder
	 *Parameters:orderId
	 *ReturnType:Optional<Order>
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */
	
	@Override
	@Transactional
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {

		Optional<Order> op = orderRep.findById(orderId);

		if (op.isPresent()) {
			return op.get();
		}
		else {
			throw new OrderIdNotFoundException(orderId);
		}
		
	}
	
	

	/*Method Name:viewAllOrder
	 *Parameters:No parameters
	 *ReturnType:List<Order>
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */
	
	@Override
	public List<Order> viewAllOrders() {

		return orderRep.findAll();
	}
	
	
	
	/*Method Name:viewPlanterByOrderId
	 *Parameters:Order
	 *ReturnType:List<Planter>
	 *Author Name:Suhana
	 *Created Date: 21/05/2021 */
	

	@Override
	public List<Planter> viewPlanterByOrderId(int orderId) throws ResourceNotFoundException {

		return orderRep.getPlanterByOrderId(orderId);
	}

	

	

}
