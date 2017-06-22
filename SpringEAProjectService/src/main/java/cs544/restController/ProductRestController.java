package cs544.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.domain.Product;
import cs544.service.ProductService;

@RestController
@RequestMapping(value="rs/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id){
		return productService.getProduct(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addProduct(@RequestBody Product product){
		System.out.println("whatssup-------");
		productService.save(product);
	}
	
	@RequestMapping(value="update", method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product){
		productService.save(product);
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id){
		productService.delete(id);
	}
	
	@RequestMapping(value="search/{name}", method=RequestMethod.GET)
	public List<Product> searchProduct(@PathVariable("name")String name){
		return productService.getTop10ProductsLike(name);
	}
}
