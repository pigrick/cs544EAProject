package cs544.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.domain.Orderline;
import cs544.domain.ShoppingCart;
import cs544.domain.User;
import cs544.restclient.UserRestClient;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRestClient userRestClient;
	
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
		return "redirect:/";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getProfile(Model model, HttpSession session){
		if(session.getAttribute("loggedInUser") == null){
			return "redirect:/login";
		}
		model.addAttribute("user", (User)session.getAttribute("loggedInUser"));
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
	
}
