package javaproject.ecommerce.BO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaproject.ecommerce.Address;
import javaproject.ecommerce.User;
import javaproject.ecommerce.DAO.UserDAO;

public class UserBO {
	
	 static UserDAO userdao = new UserDAO();
	AddressBO addressbo=new AddressBO();
	public void saveuser(User user) {
		userdao.save(user);
	}
	public String find(String username,String password) {
		List<User> us =userdao.find(username);
		String role =null;
		for (int i=0;i<us.size();i++)
		{
			if((username.equals(us.get(i).getUsername()))&&(password.equals(us.get(i).getPassword())))
			{
			 role = us.get(i).getRole();
			
			}
		}
		return role;
		
	}
	public  User usernamecheck(String createusername) {
		List<User> createuserlist = userdao.find(createusername);
		User user = null;
		for (int i=0;i<createuserlist.size();i++)
		{
			if((createusername.equals(createuserlist.get(i).getUsername())))
			{	
			
			user=createuserlist.get(i);
			}
		}
		return user;
		
	}
	public Boolean deleteuser(String s) {
		List<User> createuserlist = userdao.find(s);
		Boolean check=false;
		for (int i=0;i<createuserlist.size();i++)
		{
			if((s.equals(createuserlist.get(i).getUsername())))
			{	
			userdao.delete(createuserlist.get(i));
			check=true;
			}
		}
		return check;
		
	}
	public void update(User testuser) {
		userdao.update(testuser);
		
	}  public static boolean isValidPassword(String password) { 
		      
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";  
        
        Pattern p = Pattern.compile(regex);   
       
        if (password == null) { 
            return false; 
        }
         
        Matcher m = p.matcher(password); 
       
        return m.matches(); 
    } 
	
	
}
