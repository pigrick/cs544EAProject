package cs544.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import cs544.domain.Product;

@Controller
public class ProductRestClient {
	
	private static final String URL = "http://localhost:7775/rs/product/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Product> getProducts(){
		return Arrays.asList(restTemplate.getForObject(URL + "/all", Product[].class));
	}
	
	public Product getProduct(int id){
		return restTemplate.getForObject(URL + id, Product.class);
	}
	
	public void createProduct(Product product){
		restTemplate.postForObject(URL + "add", product, Product.class);
	}
	
	public void updateProduct(Product product){
		restTemplate.put(URL + "update", product, Product.class);
	}
	
	public void removeProduct(Product product){
		restTemplate.delete(URL + "delete/" + product.getId());
	}
	
	public List<Product> searchProduct(String name){
		
		return Arrays.asList(restTemplate.getForObject(URL + "search/" + name, Product[].class));
	}
	
}
