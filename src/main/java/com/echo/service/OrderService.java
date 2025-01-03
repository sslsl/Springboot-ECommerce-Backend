package com.echo.service;

import java.time.LocalDate;
import java.util.List;

import com.echo.exception.CustomerNotFoundException;
import com.echo.exception.LoginException;
import com.echo.exception.OrderException;
import com.echo.models.Customer;
import com.echo.models.Order;
import com.echo.models.OrderDTO;

public interface OrderService {
	public Order saveOrder(OrderDTO odto,String token) throws LoginException, OrderException;
	
	public Order getOrderByOrderId(Integer OrderId) throws OrderException;
	
	public List<Order> getAllOrders() throws OrderException;
	
	public Order cancelOrderByOrderId(Integer OrderId,String token) throws OrderException;
	
	public Order updateOrderByOrder(OrderDTO order,Integer OrderId,String token) throws OrderException,LoginException;
	
	public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException;

	public Customer getCustomerByOrderid(Integer orderId) throws OrderException;
	
	//public Customer getCustomerIdByToken(String token) throws CustomerNotFoundException;
	

	
}
