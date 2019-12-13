package com.iris.servicesimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.SellerDao;
import com.iris.models.PurchaseOrder;
import com.iris.services.SellerService;

@Transactional
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerDao sellerDao;

	public List<PurchaseOrder> getPurchaseOrders() {
		return sellerDao.getPurchaseOrders();
	}
}
