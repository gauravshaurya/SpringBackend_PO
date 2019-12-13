package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.SellerDao;
import com.iris.models.PurchaseOrder;

@Repository("sellerDao")
public class SellerDaoImpl implements SellerDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<PurchaseOrder> getPurchaseOrders() {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from com.iris.models.PurchaseOrder");
		List<PurchaseOrder> pList=q.list();
		return pList;
	}
}
