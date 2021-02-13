package javaproject.ecommerce.DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.Address;
import javaproject.ecommerce.User;

public class AddressDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(Address address) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(address);
        transaction.commit();
        session.close();
        
	}
    public List find(Address address) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        Query q = session.createQuery("from Address");
        List<Address> us = q.list();
        transaction.commit();
        session.close();
        return us;
	}
	public void update(Address updateaddress) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.update(updateaddress);
        transaction.commit();
        session.close();
		
	}
}
