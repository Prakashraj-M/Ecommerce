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
	
	public Product() {
		super();
	}

	public Product( String name, Double price, String colour, String brand) {
		super();
		
		this.name = name;
		this.price = price;
		this.colour = colour;
		Brand = brand;
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
		return "Product [name=" + name + ", price=" + price + ", colour=" + colour + ", Brand=" + Brand + "]";
	}
	
	

}
