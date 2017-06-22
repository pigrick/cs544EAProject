package cs544.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.domain.Orderline;
import cs544.domain.Product;
import cs544.domain.ShoppingCart;
import cs544.domain.User;
import cs544.restclient.ProductRestClient;
import cs544.restclient.UserRestClient;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private ProductRestClient productRestClient;
	
	@Autowired
	private UserRestClient userRestClient;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	private String getProductList(Model model){
		model.addAttribute("products", productRestClient.getProducts());
		return "productlist";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	private String getProduct(@PathVariable("id") int id, Model model){
		model.addAttribute("product", productRestClient.getProduct(id));
		return "createproduct";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String edit(@Valid Product product, BindingResult result){	
		if(result.hasErrors()){
			return "createproduct";
		}
		productRestClient.updateProduct(product);
		return "redirect:/product/all";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProduct(@ModelAttribute("product") Product product){	
		return "createproduct";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteProduct(int id){	
		Product p = new Product();
		p.setId(id);
		productRestClient.removeProduct(p);
		return "redirect:/product/all";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Valid Product product, BindingResult result){	
		if(result.hasErrors()){
			return "createproduct";
		}
		productRestClient.createProduct(product);
		return "redirect:/product/all";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String add(@RequestParam("name")String name, Model model){	
		model.addAttribute("products", productRestClient.searchProduct(name));
		return "productlist";
	}
	
	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
	public String addtocart(HttpSession session, @RequestParam("id") int id, @RequestParam("quantity") int quantity){
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		
		boolean isIn = false;
		for(Orderline or: cart.getOrderlines()){
			if(or.getProduct().getId() == id){
				or.setQuantity(or.getQuantity() + quantity);		
				isIn = true;
			}
		}
		if(isIn == false){
			Product p = productRestClient.getProduct(id);
			Orderline orderline = new Orderline(quantity, p);
			cart.addOrderLine(orderline);
		}
		
		session.setAttribute("cart", cart);
/*		User u = (User)session.getAttribute("loggedInUser");
		u = userRestClient.getUser(u.getUsername());
		u.setCart(cart);
		userRestClient.updateUser(u);*/
		
		return "redirect:/product/all";
	}
	
}
