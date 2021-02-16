package javaproject.ecommerce.BO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javaproject.ecommerce.Product;
import javaproject.ecommerce.DAO.ProductDAO;

public class ProductBO {
	ProductDAO productdao= new ProductDAO();

	public void saveproduct(Product product) {
		productdao.save(product);
	}

	public Product checkproduct(String updateproduct) {
		List<Product> productlist =productdao.list();
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

	public void updatefile(BufferedReader file) throws Exception {
		String csv ;
		
		while((csv =file.readLine())!=null){
			
			String obj[] = csv.split(",");
			if(obj.length==5) {
				Product product = new Product(obj[0],Double.parseDouble(obj[1]),obj[2],obj[3],Integer.parseInt(obj[4]));
				productdao.save(product);
			
			}
		
		}
		if(csv==null) {
			System.out.println("updated successfully");
		}
		
		
	}

	public List updatestock(String updatestock) {
		List <Product> updatestocklist = productdao.list();
		List<Product> returnstocklist = new ArrayList<Product>();
		for(int i=0;i<updatestocklist.size();i++) {
			if((updatestocklist.get(i).getName()).equalsIgnoreCase(updatestock)) {
				returnstocklist.add(updatestocklist.get(i));
			}
		}
		return returnstocklist;
	}
		
	}


