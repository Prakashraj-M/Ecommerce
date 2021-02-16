package javaproject.ecommerce.DAO;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.Product;
import javaproject.ecommerce.User;


public class ProductDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(Product product) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(product);
        transaction.commit();
        session.close();
          
	}
	public List<Product> list() {
		Session session = sf.openSession();
	    Transaction transaction = session.beginTransaction(); 
	    Query q = session.createQuery("from Product");
	    List<Product> us = q.list();       
	    session.close(); 
		return us;
	}
	public void update(Product product) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.update(product);
        transaction.commit();
        session.close();
		
	}
	
}
