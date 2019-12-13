package com.iris.daos;

import java.util.List;

import com.iris.models.PurchaseOrder;

public interface PurchaseOrderDao {
	
	public boolean createPurchaseOrder(PurchaseOrder poObj);
	public List<PurchaseOrder> getPurchaseOrders();

}