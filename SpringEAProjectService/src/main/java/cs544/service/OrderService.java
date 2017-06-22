package cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.domain.Order;
import cs544.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	public Order getOrder(int id){
		return orderRepository.findById(id);
	}
	
	public Order save(Order order){
		return orderRepository.save(order);
	}
	
	public void delete(int id){
		orderRepository.deleteById(id);
	}
	
	public List<Order> getOrdersByUsername(String name){
		return orderRepository.findByUserName(name);
	}
}
