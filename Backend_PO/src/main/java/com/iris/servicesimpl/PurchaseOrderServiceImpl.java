  
package com.iris.servicesimpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iris.daos.PurchaseOrderDao;
import com.iris.models.PurchaseOrder;
import com.iris.services.PurchaseOrderService;

@Transactional
@Service("puchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	PurchaseOrderDao purchaseOrderDao;

	public boolean createPurchaseOrder(PurchaseOrder poObj) {
		return purchaseOrderDao.createPurchaseOrder(poObj);
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrderDao.getPurchaseOrders(); 
	}
}