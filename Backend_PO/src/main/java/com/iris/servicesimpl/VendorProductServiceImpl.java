package com.iris.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iris.daos.VendorProductDao;
import com.iris.models.Product;
import com.iris.models.VendorProduct;
import com.iris.services.VendorProductService;

@Transactional
@Service("vendorProductService")
public class VendorProductServiceImpl implements VendorProductService {
	
	@Autowired
	VendorProductDao vendorProductDao; 

	public Product getProductById(int pId) {
		return vendorProductDao.getProductById(pId);
	}

	public List<Product> viewAllVendorProducts(int id) {
		return vendorProductDao.viewAllVendorProducts(id);
	}

	public boolean add(VendorProduct vpObj) {
		return vendorProductDao.add(vpObj);
	}

	public VendorProduct checkProductForVendor(int vendorId, int productId) {
		return vendorProductDao.checkProductForVendor(vendorId, productId);
	}
}
