package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iris.models.VendorProduct;
import com.iris.services.ProductService;
import com.iris.services.VendorProductService;

@RestController
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	ProductService productService;
	@Autowired
	VendorProductService vendorProductService;
	
	@RequestMapping(value = "/viewAvailableProducts", method = RequestMethod.GET)
	public ResponseEntity<?> viewAvailableProducts(@RequestParam(name="vendorId") int vendorId) {
		List<?> vendorProducts = vendorProductService.viewAllVendorProducts(vendorId);
		return new ResponseEntity<List<?>>(vendorProducts,HttpStatus.OK);
	}

	@RequestMapping(value = "/viewProductsVendor", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {
		
		map.addAttribute("productDetails", productService.viewAllProducts());
		
		return "ViewProductsVendor";
	}
	
	/*
	 * //get add or update quantity form
	 * 
	 * @RequestMapping(value="/addProductQuantity",method=RequestMethod.GET) public
	 * String getUpdateQuantityForm(ModelMap map) {
	 * map.addAttribute("productDetails", productService.viewAllProducts()); return
	 * "AddProductQuantity"; }
	 */

	//save or update product
	@RequestMapping(value="/addQuantity",method=RequestMethod.POST)
	public ResponseEntity<?> addQuantity(@RequestParam(name="productId") int productId,
			@RequestParam("quantity") int quantity, @RequestParam(name="vendorId") int vendorId){
		VendorProduct r=vendorProductService.checkProductForVendor(vendorId, productId);
		if(r!=null) {
			r.setQuantity(r.getQuantity()+quantity);
		}
		else {
			r = new VendorProduct();
			r.setVendorId(vendorId);
			r.setProductId(productId);
			r.setQuantity(quantity);
		}
		boolean s=vendorProductService.add(r);
		if(s) {
			return new ResponseEntity<Object>(r,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Prodct didn't get added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
