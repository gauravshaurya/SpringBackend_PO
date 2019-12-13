package com.iris.daos;

import java.util.List;

import com.iris.models.PurchaseOrder;

public interface SellerDao {
	
	public List<PurchaseOrder> getPurchaseOrders();

}
