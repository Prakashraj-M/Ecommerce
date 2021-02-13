package javaproject.ecommerce.DAO;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.User;

public class UserDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(User user) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(user);
        transaction.commit();
        session.close();
        
	}
    public List find(String un) {
      Session session = sf.openSession();
      Transaction transaction = session.beginTransaction(); 
       Query q = session.createQuery("from User");
       List<User> us = q.list();       
       session.close();    
       return us;
	}
	public void delete(User user) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.delete(user);
        transaction.commit();
        session.close();
		
	}
	public void update(User testuser) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.update(testuser);
        transaction.commit();
        session.close();
		
	}
} 