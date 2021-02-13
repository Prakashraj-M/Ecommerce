package javaproject.ecommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.Rating;

public class RatingDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(Rating rating) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(rating);
	}
}
