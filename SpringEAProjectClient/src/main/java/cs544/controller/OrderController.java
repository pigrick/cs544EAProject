package cs544.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.util.SessionIdGeneratorBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.domain.User;
import cs544.restclient.OrderRestClient;
import cs544.restclient.UserRestClient;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private UserRestClient userRestClient;
	@Autowired
	private OrderRestClient orderRestClient;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String getOrders(Model model){
		model.addAttribute("orders", orderRestClient.getOrders());
		return "orders";
	}
	
	@RequestMapping(value="/myorder", method=RequestMethod.GET)
	public String getMyOrders(Model model, HttpSession session){
		User u = (User)session.getAttribute("loggedInUser");
		model.addAttribute("orders", orderRestClient.getOrdersByUsername(u.getUsername()));
		return "orders";
	}
}
