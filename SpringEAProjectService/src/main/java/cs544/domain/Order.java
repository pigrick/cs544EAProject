package cs544.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OrderT")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@OneToOne
	private Address shippingAddress;
	@OneToOne
	private CreditCard creditCard;
	@OneToMany
	private List<Orderline> orderlines;
	@ManyToOne
	private User user;
	
	public Order(){
		
	}
	
	
	
	public Order(Address shippingAddress, CreditCard creditCard, List<Orderline> orderlines, User user) {
		orderDate = new Date();
		this.shippingAddress = shippingAddress;
		this.creditCard = creditCard;
		this.orderlines = orderlines;
		this.user = user;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
	
}
