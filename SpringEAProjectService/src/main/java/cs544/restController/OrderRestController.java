package cs544.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.domain.Order;
import cs544.service.OrderService;

@RestController
@RequestMapping(value="rs/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Order getProduct(@PathVariable("id") int id){
		return orderService.getOrder(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addOrder(@RequestBody Order order){
		orderService.save(order);
	}
	
	@RequestMapping(value="update", method=RequestMethod.PUT)
	public void updateOrder(@RequestBody Order order){
		orderService.save(order);
	}
}
