package javaproject.ecommerce;

import javax.persistence.*;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="rating")
	private Double rating;
	
	@Column(name="comment")
	private String comment;	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	
	
	public Rating ( Double rating, String comment, Product product, User user) {
		super();		
		this.rating = rating;
		this.comment = comment;
		this.product = product;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
