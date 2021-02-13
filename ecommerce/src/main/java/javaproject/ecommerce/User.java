package javaproject.ecommerce;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String mobileno;
	
	@Column(name="user_name",unique=true)	
	private String username;
	
	
	@Column(name="password")	
	private String password;
	
	@Column(name="role")	
	private String role;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<Address> listOfAddress= new ArrayList<Address>();
	
	public User() {
		super();
	}
	public User( String name, String email, String mobileno, String username, String password, String role) {
		super();
		
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.username = username;
		this.password = password;
		this.role = role;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
}
	