package cs544.controller;

import static org.mockito.Mockito.inOrder;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.domain.Address;
import cs544.domain.CreditCard;
import cs544.domain.Order;
import cs544.domain.Orderline;
import cs544.domain.ShoppingCart;
import cs544.domain.User;
import cs544.restclient.OrderRestClient;
import cs544.restclient.UserRestClient;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Autowired
	private OrderRestClient orderRestClient;
	

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String getAllUser(Model model){
		model.addAttribute("users",userRestClient.getUsers());
		return "userlist";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user){	
		return "createuser";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String add(@Valid User user, BindingResult result){	
		if(result.hasErrors()){
			return "createuser";
		}
		userRestClient.createUser(user);

		return "redirect:/login";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getProfile(Model model, HttpSession session, @ModelAttribute("creditCard") CreditCard creditCard){
		if(session.getAttribute("loggedInUser") == null){
			return "redirect:/login";
		}
		return "userprofile";
	}
	
	@RequestMapping(value="/profile/edit", method=RequestMethod.GET)
	public String getEditProfile(Model model, HttpSession session){
		if(session.getAttribute("loggedInUser") == null){
			return "redirect:/login";
		}
		model.addAttribute("user", userRestClient.getUser(((User)session.getAttribute("loggedInUser")).getUsername()));
		return "createuser";
	}
	
	@RequestMapping(value="/profile/edit", method=RequestMethod.POST)
	public String editProfile(@Valid User user, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			return "createuser";
		}
		
		userRestClient.updateUser(user);

		session.setAttribute("loggedInUser", user);
		return "redirect:/user/profile";
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String getCart(){
		return "cart";
	}
	
	@RequestMapping(value="/cart/change", method=RequestMethod.POST)
	public String changeCart(HttpSession session, @RequestParam("id")int id, @RequestParam("quantity")int quantity){
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		for(Orderline or: cart.getOrderlines()){
			if(or.getProduct().getId() == id){
				if(quantity == 0){
					cart.getOrderlines().remove(or);
				} else {
					or.setQuantity(quantity);
				}
			}
		}
		return "redirect:/user/cart";
	}
	
	@RequestMapping(value="/profile/addcc", method=RequestMethod.POST)
	public String addCC(@Valid CreditCard creditCard, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			return "userprofile";
		}
		User u = userRestClient.getUser(((User)session.getAttribute("loggedInUser")).getUsername());
		u.addCreditCard(creditCard);
		userRestClient.updateUser(u);
		session.setAttribute("loggedInUser", u);
		return "redirect:/user/profile";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String getCheckout(@ModelAttribute("address") Address address, HttpSession session){		
		return "checkout";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String Checkout(HttpSession session, @Valid Address address, BindingResult result, 
			@RequestParam("ownaddress") String ownaddress, @RequestParam("cc") int id){
		System.out.println(address.getStreet() + address.getZipcode());
		User user = userRestClient.getUser(((User)session.getAttribute("loggedInUser")).getUsername());
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		CreditCard card = null;
		Order order = null;
		for(CreditCard c : user.getCreditCards()){
			if(c.getId() == id){
				card = c;
			}
		}
		if(!ownaddress.equals("yes")){
			if(result.hasErrors()){
				return "checkout";
			}
			
			order = new Order(address, card, cart.getOrderlines());
			
		} else {			
			order = new Order(user.getAddress(), card, cart.getOrderlines());
		}
		user.addOrder(order);
		session.setAttribute("cart", new ShoppingCart());
		userRestClient.updateUser(user);
		return "redirect:/";
	}
}
