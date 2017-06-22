package cs544.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Product findById(int id);
	public List<Product> findTop10ByNameIgnoreCaseLike(String name);
}
