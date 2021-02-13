package javaproject.ecommerce.BO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javaproject.ecommerce.Product;
import javaproject.ecommerce.DAO.ProductDAO;

public class ProductBO {
	ProductDAO productdao= new ProductDAO();

	public void saveproduct(Product product) {
		productdao.save(product);
	}

	public Product checkproduct(String updateproduct) {
		List<Product>productlist =productdao.list();
		Product product = null;
		for(int i=0;i<productlist.size();i++) {
			if(updateproduct.equalsIgnoreCase(productlist.get(i).getName()));{
				product=productlist.get(i);
			}
		}
		return product;
			
	}

	public void updateproduct(Product product) {
		productdao.update(product);
		
	}

	public void updatefile(BufferedReader file) throws IOException {
		String csv = null;
		
		do {
		csv = file.readLine();
		String []obj = csv.split(",");
		if(obj.length<4) {
			Product product = new Product(obj[0],Double.parseDouble(obj[1]),obj[2],obj[3]);
			productdao.save(product);
			
		}
		
		}while(csv!=null);
		
		
		
	}
		
	}


