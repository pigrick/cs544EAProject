package cs544.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cs544.domain.Product;
import cs544.repository.ProductRepository;

@Service
public class Scheduler {
	
	@Autowired
	private ProductRepository productRespository;
	
	@Scheduled(cron="0 0 0 ? * MON")
	public void putDiscount(){
		List<Product> products = productRespository.findAll();
		for(Product p : products){
			p.setSalePrice(p.getSalePrice() * 0.8);			
		}
		productRespository.saveAll(products);
	}
	
	@Scheduled(cron="0 0 0 ? * SUN")
	public void takeOutDiscount(){
		List<Product> products = productRespository.findAll();
		for(Product p : products){
			p.setSalePrice(p.getSalePrice() * 1.25);			
		}
		productRespository.saveAll(products);
	}
}
