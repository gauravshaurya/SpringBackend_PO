package com.iris.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.PurchaseOrderItemsDao;
import com.iris.models.PurchaseOrderItems;
import com.iris.services.PurchaseOrderItemsService;

@Transactional
@Service("puchaseOrderItemsService")
public class PurchaseOrderItemsServiceImpl implements PurchaseOrderItemsService {
	
	@Autowired
	PurchaseOrderItemsDao purchaseOrderItemsDao;

	public List<PurchaseOrderItems> getPoItemsById(int purchaseOrderId) {
		return purchaseOrderItemsDao.getPoItemsById(purchaseOrderId);
	}

}
