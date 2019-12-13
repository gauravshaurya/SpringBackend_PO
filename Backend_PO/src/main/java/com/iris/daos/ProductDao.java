package com.iris.daos;

import java.util.List;

import com.iris.models.Product;

public interface ProductDao {
	public boolean addProduct(Product productObj);
	public boolean deleteProduct(Product pObj);
	public Product getProductById(int productId);
	public Product getProductByName(String productName);
	public List<Product> viewAllProducts();
}
