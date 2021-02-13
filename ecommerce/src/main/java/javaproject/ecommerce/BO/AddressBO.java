package javaproject.ecommerce.BO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javaproject.ecommerce.Address;
import javaproject.ecommerce.DAO.AddressDAO;

public class AddressBO {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Address address = new Address();
	AddressDAO addressdao = new AddressDAO();
	public void saveaddress(Address address) {
		addressdao.save(address);
		
	}
	public Address Addaddress() throws IOException {
	
		return address;
	}
	public void updateaddress(Address updateaddress) {
		addressdao.update(updateaddress);
		
		
	}
	
}
