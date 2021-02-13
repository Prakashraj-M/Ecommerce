package javaproject.ecommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaproject.ecommerce.PurchaseOrder;

public class PurchaseOrderDAO {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry register = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sf = cfg.buildSessionFactory(register);
	public void save(PurchaseOrder purchaseorder) {
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction(); 
        session.save(purchaseorder);
        transaction.commit();
        session.close();
        
	}
	
}
