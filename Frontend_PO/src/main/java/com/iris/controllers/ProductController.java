package com.iris.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.iris.models.Product;
import com.iris.services.ProductService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public ResponseEntity<?> getProductById(@RequestParam(name="productId") int productId) {
		System.out.println("I m here in controller");
		Product pObj=productService.getProductById(productId);
		System.out.println("Product Obj : "+pObj);
		return new ResponseEntity<Product>(pObj,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<?> viewAllProducts() {
		List<Product> list = productService.viewAllProducts();
		if(list.size()!=0) {
			return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("List is empty",HttpStatus.OK);
		}
	}

}