package com.iris.services;

import java.util.List;
import com.iris.models.PurchaseOrder;

public interface PurchaseOrderService {
	
	public boolean createPurchaseOrder(PurchaseOrder pobj);
	public List<PurchaseOrder> getPurchaseOrders();

}