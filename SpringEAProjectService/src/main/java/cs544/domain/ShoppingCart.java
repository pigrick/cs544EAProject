package cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private int id;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Orderline> orderlines;
	
	public ShoppingCart(){
		orderlines = new ArrayList<Orderline>();
	}	
	
	public ShoppingCart(List<Orderline> orderlines) {
		super();
		this.orderlines = orderlines;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Orderline> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	public double getTotalPrice(){
		double sum = 0;
		for(Orderline or: orderlines){
			sum += or.getTotalPrice();
		}
		return sum;
	}
	
	public void addOrderLine(Orderline orderline){
		orderlines.add(orderline);
	}
	
	public double getTotalWeight(){
		double sum = 0;
		for(Orderline or: orderlines){
			sum += or.getTotalWeight();
		}
		return sum;
	}
	
	public int getSize(){
		return orderlines.size();
	}
}
