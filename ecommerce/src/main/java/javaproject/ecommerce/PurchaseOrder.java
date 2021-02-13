package javaproject.ecommerce;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name ="purchased_date")
	private String purchasedDate;
	
	@Column(name ="total_price")
	private Double totalPrice;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy = "purchaseOrder")
	private List<PurchaseOrderItem>purchaseorderitem = new ArrayList<PurchaseOrderItem>();
	
	
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(String purchasedDate, Double totalPrice, User user, Address address,
			List<PurchaseOrderItem> purchaseorderitem) {
		super();
		this.purchasedDate = purchasedDate;
		this.totalPrice = totalPrice;
		this.user = user;
		this.address = address;
		this.purchaseorderitem = purchaseorderitem;
	}
	public String getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<PurchaseOrderItem> getPurchaseorderitem() {
		return purchaseorderitem;
	}
	public void setPurchaseorderitem(List<PurchaseOrderItem> purchaseorderitem) {
		this.purchaseorderitem = purchaseorderitem;
	} 

}