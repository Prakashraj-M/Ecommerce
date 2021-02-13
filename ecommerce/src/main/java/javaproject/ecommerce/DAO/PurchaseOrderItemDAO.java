package javaproject.ecommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.PurchaseOrderItem;

public class PurchaseOrderItemDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(PurchaseOrderItem purchaseorderItem) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(purchaseorderItem);
        transaction.commit();
        session.close();
        
	}
	
}
