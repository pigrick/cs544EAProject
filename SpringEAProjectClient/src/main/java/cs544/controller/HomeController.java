package cs544.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.domain.Address;

import cs544.domain.Product;
import cs544.domain.ShoppingCart;
import cs544.domain.User;
import cs544.restclient.OrderRestClient;
import cs544.restclient.ProductRestClient;
import cs544.restclient.UserRestClient;

@Controller
public class HomeController {

	@Autowired
	private OrderRestClient orderRestClient;
	@Autowired
	private ProductRestClient productRestClient;
	@Autowired
	private UserRestClient userRestClient;

	@RequestMapping(value = "/populate", method = RequestMethod.GET)
	public String populate() {
		userRestClient.createUser(new User("rick", "123", "mama", "lala", "rick@gmail.com",
				new Address("1000 N 4th ST", "Fairfield", "Iowa", "US", "52557")));
		productRestClient.createProduct(
				new Product("Teletub", "It is one of the best character in the whole wide would", 30.0, 33, 2));
		productRestClient.createProduct(new Product("Rise of them",
				"It is one of the super annoying Ebook in the whole wide would", 15.0, 31, 5));
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Principal principal, HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		User u = (User) session.getAttribute("loggedInUser");
		if (u == null) {
			if (principal != null) {
				if (!principal.getName().equals("yeerick")) {
					u = userRestClient.getUser(principal.getName());
					session.setAttribute("loggedInUser", u);
					session.setAttribute("cart", u.getCart());
				}
			}
		}

		return "index";
	}

	@RequestMapping(value = "/logoutsuccess", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
