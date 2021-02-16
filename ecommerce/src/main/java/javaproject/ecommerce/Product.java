package javaproject.ecommerce;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="price")
	private Double price;
	
	@Column(name ="colour")
	private String colour;
	
	@Column(name ="brand")
	private String Brand;
	
	@Column (name="Stock")
	private Integer stock;
	
	public Product() {
		super();
	}

	public Product( String name, Double price, String colour, String brand,Integer stock) {
		super();
		
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.Brand = brand;
		this.stock=stock;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}

	@Override
	public String toString() {
		return " name=" + name + "\n price=" + price + "\n colour=" + colour + "\n Brand=" + Brand + "\n stock="
				+ stock ;
	}

	
	

}
