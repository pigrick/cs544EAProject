package cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.domain.Order;
import cs544.domain.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order findById(int id);
}
