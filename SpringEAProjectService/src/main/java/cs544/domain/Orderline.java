package cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orderline {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	@OneToOne
	private Product product;
	
	public Orderline(){}
	
	public Orderline(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotalPrice(){
		return product.getSalePrice() * quantity;
	}
	
	public double getTotalWeight(){
		return product.getWeight() * quantity;
	}

}
