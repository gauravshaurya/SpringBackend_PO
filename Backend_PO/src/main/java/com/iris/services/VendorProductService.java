package com.iris.services;

import java.util.List;

import com.iris.models.Product;
import com.iris.models.VendorProduct;

public interface VendorProductService {
	
	public Product getProductById(int pId) ;
	public List<Product> viewAllVendorProducts(int id);
	public boolean add(VendorProduct vpObj);
	public VendorProduct checkProductForVendor(int vendorId,int productId);
}
