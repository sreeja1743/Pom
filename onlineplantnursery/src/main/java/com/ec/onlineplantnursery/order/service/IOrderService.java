package com.ec.onlineplantnursery.order.service;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.requestDto.OrderRequestDTO;

public interface IOrderService {
	Order addOrder(Order order) throws ResourceNotFoundException;
	Order updateOrder(Order order) throws ResourceNotFoundException;
	Order deleteOrder(int orderId) throws ResourceNotFoundException;
	Order viewOrder(int  orderId) throws OrderIdNotFoundException;
	List<Order> viewAllOrders();
	List<Planter> viewPlanterByOrderId(int id) throws ResourceNotFoundException;
	
}
