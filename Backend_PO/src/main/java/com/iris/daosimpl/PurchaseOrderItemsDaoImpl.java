package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.PurchaseOrderItemsDao;
import com.iris.models.PurchaseOrderItems;

@Repository("PurchaseOrderItemsDao")
public class PurchaseOrderItemsDaoImpl implements PurchaseOrderItemsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<PurchaseOrderItems> getPoItemsById(int purchaseOrderId) {
		try {
			
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.iris.models.PurchaseOrderItems where purchaseOrderId=:x");
			q.setParameter("x", purchaseOrderId);
			List<PurchaseOrderItems> poItemsList = q.list();
			return poItemsList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
