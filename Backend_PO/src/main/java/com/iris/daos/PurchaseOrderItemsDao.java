package com.iris.daos;

import java.util.List;

import com.iris.models.PurchaseOrderItems;

public interface PurchaseOrderItemsDao {
	public List<PurchaseOrderItems> getPoItemsById(int purchaseOrderId);
}
