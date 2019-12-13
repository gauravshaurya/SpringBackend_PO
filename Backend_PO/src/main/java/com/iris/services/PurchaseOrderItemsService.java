package com.iris.services;

import java.util.List;

import com.iris.models.PurchaseOrderItems;

public interface PurchaseOrderItemsService {
	public List<PurchaseOrderItems> getPoItemsById(int purchaseOrderId);
}
