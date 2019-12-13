package com.iris.daosimpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iris.daos.PurchaseOrderDao;
import com.iris.models.PurchaseOrder;

@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	
	public boolean createPurchaseOrder(PurchaseOrder poObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
	
			session.persist(poObj);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public List<PurchaseOrder> getPurchaseOrders() {
		try {

			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.PurchaseOrder");
			
				List<PurchaseOrder>list=query.list();	
	
				return list;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}