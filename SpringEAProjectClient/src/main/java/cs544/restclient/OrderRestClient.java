package cs544.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import cs544.domain.Order;

@Controller
public class OrderRestClient {
	
	private static final String URL = "http://localhost:7775/rs/order/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Order> getOrders(){
		return Arrays.asList(restTemplate.getForObject(URL + "/all", Order[].class));
	}
	
	public Order getOrder(int id){
		return restTemplate.getForObject(URL + id, Order.class);
	}
	
	public void createOrder(Order order){
		restTemplate.postForObject(URL + "add", order, Order.class);
	}
	
	public void updateORder(Order order){
		restTemplate.put(URL + "update", order, Order.class);
	}
	
	public void removeOrder(Order order){
		restTemplate.delete(URL + "delete/" + order.getId());
	}
}
