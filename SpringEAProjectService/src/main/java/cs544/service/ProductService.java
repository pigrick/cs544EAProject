package cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.domain.Product;
import cs544.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProduct(int id){
		return productRepository.findById(id);
	}
	
	public List<Product> getTop10ProductsLike(String name){
		return productRepository.findTop10ByNameIgnoreCaseLike("%" + name + "%");
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public void delete(int id){
		productRepository.deleteById(id);
	}
	
}
