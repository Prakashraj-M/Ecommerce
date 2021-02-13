package javaproject.ecommerce;

import javax.persistence.*;

@Entity
public class PurchaseOrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name ="purchaseorder_id")
	private PurchaseOrder purchaseOrder;
	
	
	public PurchaseOrderItem() {
		super();
	}

	public PurchaseOrderItem( int quantity, double unitPrice, Product product, PurchaseOrder purchaseOrder) {
		super();		
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
		this.purchaseOrder = purchaseOrder;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
}
