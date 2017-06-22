package cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cs544.domain.Order;
import cs544.domain.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order findById(int id);
	
	@Query("select distinct o from User u join u.order o where u.username = ?1")
	public List<Order> findByUserName(String username);
}
