package com.iris.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.ProductDao;
import com.iris.models.Product;
import com.iris.services.ProductService;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	public boolean addProduct(Product productObj) {
		return productDao.addProduct(productObj);
	}

	public boolean deleteProduct(Product pObj) {
		return productDao.deleteProduct(pObj);

	}

	public Product getProductById(int productId) {
		return productDao.getProductById(productId);
	}

	public Product getProductByName(String productName) {
		return productDao.getProductByName(productName);
	}

	public List<Product> viewAllProducts() {
		return productDao.viewAllProducts();
	}
}
