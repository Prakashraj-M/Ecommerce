package javaproject.ecommerce;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javaproject.ecommerce.BO.AddressBO;
import javaproject.ecommerce.BO.ProductBO;
import javaproject.ecommerce.BO.UserBO;
import javaproject.ecommerce.DAO.ProductDAO;
import javaproject.ecommerce.DAO.PurchaseOrderDAO;
import javaproject.ecommerce.DAO.PurchaseOrderItemDAO;
import javaproject.ecommerce.DAO.RatingDAO;
import javaproject.ecommerce.DAO.UserDAO;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Address> AddressList= new ArrayList<Address>();
		List<PurchaseOrderItem> POIlist= new ArrayList<PurchaseOrderItem>();
		AddressBO addressbo = new AddressBO();
		
		
		/*________________________________________________________________________________________________________________________________________________
		User user_admin = new User("Sujith","admin@gmail.com","9943895950","sujithbr","admin123","Admin");
		
    	User customer_1 = new User("rahul","rahul@gmail.com","9943895951","rahulsri","customer_1","Customer");
    	User customer_2 = new User("Gowri","gowri@gmail.com","7397675921","gowrish","customer_2","Customer");
    	
    	Address address_1 = new Address("L1","WkGardens","cbe","TN","pnPalayam","641017",customer_1);
    	Address address_2 = new Address("L2","Katoor Rd","cbe","TN","Bluedart","641017",customer_2);
    	Address address_3 = new Address("L3","kGardens","cbe","TN","BBQ Nation","641017",user_admin);
    	user_admin.getListOfAddress().add(address_3);
    	customer_1.getListOfAddress().add(address_1);
    	customer_2.getListOfAddress().add(address_2);

    	    	
    	UserBO userBO = new UserBO();
    	userBO.saveuser(user_admin);
    	userBO.saveuser(customer_1);
    	userBO.saveuser(customer_2);    	
    	addressbo.saveaddress(address_1);
    	addressbo.saveaddress(address_2);
    	addressbo.saveaddress(address_3);

    	
    	Product product_1 = new Product("shoe",1500.00,"black","Nike",12);
    	Product product_2 = new Product("Watch",1290.00,"Red","Fast track",20);
    	Product product_3 = new Product("Sunglasses",3000.00,"Yellow","Rayband",30);
    	ProductDAO productBo = new ProductDAO();
    	productBo.save(product_1);
    	productBo.save(product_2);
    	productBo.save(product_3);
    	________________________________________________________________________________________________________________________________________________*/
		String role =null;
		UserBO userbo= new UserBO();
		UserDAO userdao = new UserDAO();
		
		ProductBO productbo = new ProductBO();
		PurchaseOrderItemDAO purchaseorderitemdao = new PurchaseOrderItemDAO();
		new PurchaseOrderDAO();
		RatingDAO ratingdo = new RatingDAO();
		Integer count=0;
		do
		{
		System.out.println("Enter UserName");
		String username = br.readLine();  
		System.out.println("Enter Password");
		String pass = br.readLine();		   
		role = userbo.find(username,pass);
		if (role!=null) {
			count=count+1;
		}
		if(count==0) {
			System.out.println("Enter Valid Username or Password");
		}
		
		}while(count<=0);	
		if(role.equalsIgnoreCase("Admin")) {
			Integer Entry=0;
			do {
			System.out.println("1.User\n2.Address\n3.Product\n4.Exit");
			Entry=Integer.parseInt(br.readLine());
			switch(Entry) {
				case 1:
					System.out.println("1.Create user\n2.Update User\n3.Delete User\n4.exit");					
					switch(Integer.parseInt(br.readLine())) {
						case 1:
							Boolean check=true;
							User user = new User();
							User checkuser=null;
							System.out.println("Enter Name of the User");
							user.setName(br.readLine());
							System.out.println("Enter Email of User");
							user.setEmail(br.readLine());
							String createusername ="";
							do {
								System.out.println("Enter Username ");
								createusername =br.readLine();
								checkuser=userbo.usernamecheck(createusername);
								if(checkuser!=null) 
									{System.out.println("UserName Already Taken");}
								}while(checkuser!=null);
							user.setUsername(createusername);
							System.out.println("Enter mobile number");
							user.setMobileno(br.readLine());
							String password=null;
							Boolean checkpassword=false;
							do {
							System.out.println("Enter Password");
							password=br.readLine();
							checkpassword=userbo.isValidPassword(password);
							if(checkpassword==false) {
								System.out.println("Password Should Have Minimum one Uppercase Alphabet,one Special Character,one Numeric Value,");
							}
							}while(checkpassword==false);
							user.setPassword(password);
							System.out.println("Enter Role (Admin or Customer)");
							user.setRole(br.readLine());
							Address address =new Address();
							System.out.println("Door Number");
							address.setAddressline1(br.readLine());
							System.out.println("Enter Area");
							address.setAddressline2(br.readLine());
							System.out.println("Enter City");
							address.setCity(br.readLine());
							System.out.println("Enter State");
							address.setState(br.readLine());
							System.out.println("Enter Pincode");
							address.setPincode(br.readLine());
							System.out.println("Enter Landmark");
							address.setLandmark(br.readLine());
							AddressList.add(address);
							user.setListOfAddress(AddressList);
							address.setUser(user);
							userbo.saveuser(user);
							addressbo.saveaddress(address);
							break;
						case 2:
							User user1=null;
							do {
							System.out.println("Enter Username to update");
							String updateuser = br.readLine();							
							user1 = userbo.usernamecheck(updateuser);
							if(user1==null) 
								{System.out.println("Enter valid username");}
							}while (user1==null);
							Integer n=0;
							Integer count1 =0;
							do {
									System.out.println("What do you want to change\n1.Name\n2.email\n3.mobileno\n4.usernamae\n5.password\n6.role\n7.exit");
									n = Integer.parseInt(br.readLine());
									
									switch(n) {
									case 1:
										System.out.println("Enter Name of the User");
										user1.setName(br.readLine());
										break;
									case 2:
										System.out.println("Enter Email of User");
										user1.setEmail(br.readLine());
										break;
									case 3:
											System.out.println("Enter mobile number");
											user1.setMobileno(br.readLine());
											break;
										case 4:
											User checkuser1 =new User();
											String createuserName ="";
											do {
												System.out.println("Enter Username ");
												createuserName =br.readLine();
												checkuser1=userbo.usernamecheck(createuserName);
												if(checkuser1!=null) 
													{System.out.println("UserName Already Taken");}
												}while(checkuser1!=null);
											user1.setUsername(createuserName);
											break;
										case 5:
											String userpassword=null;
											Boolean checkuserpassword=false;
											do {
											System.out.println("Enter Password");
											userpassword=br.readLine();
											checkuserpassword=userbo.isValidPassword(userpassword);
											if(checkuserpassword==false) {
												System.out.println("Password Should Have Minimum 8 characters,one Uppercase Alphabet,one Special Character,one Numeric Value,");
											}
											}while(checkuserpassword==false);
											user1.setPassword(userpassword);
											break;
										case 6:
											System.out.println("Enter Role (Admin or Customer)");
											user1.setRole(br.readLine());
											break;									
													 
										}
									}while(n<=6);
									userbo.update(user1);
								}
							break;
				            				
					
				case 2:
					System.out.println("1.Add Address\n2.update Address");
					switch(Integer.parseInt(br.readLine())) {
					case 1:
						User UpdateUser= new User();
						Address Addaddress = new Address();						
						do {
							System.out.println("Enter Username to Add Address");;
							String updateuser = br.readLine();							
							UpdateUser = userbo.usernamecheck(updateuser);
							if(UpdateUser==null) 
								{System.out.println("Enter valid username");}
							}while (UpdateUser==null);
						System.out.println("Door Number");
						Addaddress.setAddressline1(br.readLine());
						System.out.println("Enter Area");
						Addaddress.setAddressline2(br.readLine());
						System.out.println("Enter City");
						Addaddress.setCity(br.readLine());
						System.out.println("Enter State");
						Addaddress.setState(br.readLine());
						System.out.println("Enter Pincode");
						Addaddress.setPincode(br.readLine());
						System.out.println("Enter Landmark");
						Addaddress.setLandmark(br.readLine());
						AddressList.add(Addaddress);
						UpdateUser.setListOfAddress(AddressList);
						Addaddress.setUser(UpdateUser);
						userbo.update(UpdateUser);
						addressbo.saveaddress(Addaddress);
						break;
					case 2:
						User updateaddressuser= new User();
						Address updateaddress = new Address();
						Integer Addresscount=0;
						Integer Addressindex =0;
						do {
							System.out.println("Enter Username to Add Address");;
							String updateuser = br.readLine();							
							updateaddressuser = userbo.usernamecheck(updateuser);
							if(updateaddressuser==null) 
								{System.out.println("Enter valid username");}
							}while (updateaddressuser==null);						 
						for(int i=0;i<updateaddressuser.getListOfAddress().size();i++) {
							updateaddress=updateaddressuser.getListOfAddress().get(i);
							System.out.print((i+1)+" . ");
							System.out.println(updateaddress);
							System.out.println("****************");
							Addresscount++;
							}
						do {
						System.out.println("Enter Address you want to change");
						Addressindex = Integer.parseInt(br.readLine());
						if(Addressindex>Addresscount) {
							System.out.println("No Address Found. Enter Valid Number");
						}
						}while(Addressindex>Addresscount);
						updateaddress=updateaddressuser.getListOfAddress().get((Addressindex-1));
						System.out.println("Door Number");
						updateaddress.setAddressline1(br.readLine());
						System.out.println("Enter Area");
						updateaddress.setAddressline2(br.readLine());
						System.out.println("Enter City");
						updateaddress.setCity(br.readLine());
						System.out.println("Enter State");
						updateaddress.setState(br.readLine());
						System.out.println("Enter Pincode");
						updateaddress.setPincode(br.readLine());
						System.out.println("Enter Landmark");
						updateaddress.setLandmark(br.readLine());						
						
						addressbo.updateaddress(updateaddress);
						
					}
					break;
				case 3:
					Integer productselect=0;
					do {						
					System.out.println("1.Create Product\n2.Update Product \n3.Bulk upload \n4.Update Stock of Product\n5.exit");
					productselect= Integer.parseInt(br.readLine());
					Product product = new Product();
					switch(productselect) {
					case 1:
						System.out.println("Enter Name of product ");
						String name = br.readLine();
						product.setName(name);
						System.out.println("Enter Price of the Product");
						Double price = Double.parseDouble(br.readLine());
						product.setPrice(price);
						System.out.println("Enter colour of Product");
						String color =br.readLine();
						product.setColour(color);
						System.out.println("Enter Brand of Product");
						String brand = br.readLine();						
						product.setBrand(brand);
						System.out.println("Enter Stock of Product");
						String stock = br.readLine();						
						product.setBrand(stock);
						productbo.saveproduct(product);
						break;
					case 2:
						String updateproduct ="";
						Product updateproductobj =null;
						do {
						System.out.println("Enter Product to Update");					
						updateproduct =br.readLine();
						updateproductobj=productbo.checkproduct(updateproduct);
						if(updateproductobj==null) {
							System.out.println("No Product Found Enter valid Product");
						}
					}while(updateproductobj==null);
						Integer updateselection=0;
						do {
						System.out.println("Select which to be updated \n 1.Name of the Product \n 2.Price \n 3.Colour \n 4.Brand\n 5.Stock\n6.exit");
						updateselection = Integer.parseInt(br.readLine());
						switch(updateselection) {
						case 1:
						System.out.println("Enter Name of product ");
						String updatename = br.readLine();
						updateproductobj.setName(updatename);
						break;
						
						case 2:
						System.out.println("Enter Price of the Product");
						Double updateprice =Double.parseDouble(br.readLine());
						updateproductobj.setPrice(updateprice);
						
						break;
						case 3:
						System.out.println("Enter colour of Product");
						String updatecolor =br.readLine();
						updateproductobj.setColour(updatecolor);
						break;
						case 4:
						System.out.println("Enter Brand of Product");
						String updatebrand = br.readLine();
						updateproductobj.setBrand(updatebrand);
						break;
						case 5:
							System.out.println("Enter Stock of Product");
							String updatestock = br.readLine();
							updateproductobj.setBrand(updatestock);
							break;	
							}
						}while(updateselection<=5);
						productbo.updateproduct(updateproductobj);
						break;
					case 3:
						String selection ="yes";
						do {
							BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\91944\\git\\Ecommerce\\ecommerce\\src\\main\\java\\file.csv"));
							productbo.updatefile(file);
							System.out.println("Do you want to continue(yes/no)");
							selection=br.readLine();
							
						}while(selection.equalsIgnoreCase("yes"));
						break;
					case 4 :
						List<Product> updatestocklist = null;
						String Choice ="yes";
						do {
						 do {
							 System.out.println("Enter a product name to update stock");
							 String updatestock = br.readLine();
							 updatestocklist = productbo.updatestock(updatestock);
							 for(int i=0;i<updatestocklist.size();i++) {
								 System.out.print((i+1)+" ");
								 System.out.println( updatestocklist.get(i));
								 System.out.println("******************************");
							 }
							 if(updatestocklist.isEmpty()) {
								 System.out.println("Product Not Found");
							 }
						 }while(updatestocklist.isEmpty());
						 Integer s_no =0;
						 do {
							 System.out.println("Enter Product S.No to update stock");
							 s_no =Integer.parseInt(br.readLine());
							 if(s_no>updatestocklist.size()) {
								 System.out.println("Please Enter Valid Input");
							 }
						 	}while(s_no>updatestocklist.size());
						 	Product StockOfproduct = updatestocklist.get(s_no-1);
						 	System.out.println("Enter the new stock of "+StockOfproduct.getBrand()+" "+StockOfproduct.getName());
						 	System.out.println("[Old Stock of this Product is "+StockOfproduct.getStock()+"]");
						 	Integer updatestocknumber = Integer.parseInt(br.readLine());
						 	StockOfproduct.setStock(updatestocknumber);
						 	productbo.updateproduct(StockOfproduct);
						 	System.out.println("Do u want to Continue (yes/no)");
						 	Choice = br.readLine();												
						}while(Choice.equalsIgnoreCase("yes"));						
					}
					}while(productselect<=4);
					}			
			}while(Entry<4);
		}
/*____________________________________________________________________________________________________________________________________________________*/
else if(role.equalsIgnoreCase("Customer")) {
		System.out.println("1");
		}
		    
		

	
	
		}
}
 