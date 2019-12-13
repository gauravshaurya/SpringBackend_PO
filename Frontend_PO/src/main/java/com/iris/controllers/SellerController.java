package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.PurchaseOrder;
import com.iris.services.ProductService;
import com.iris.services.SellerService;
import com.iris.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class SellerController {
	
	@Autowired
	UserService userService;
	@Autowired
	SellerService sellerService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/purchaseOrders", method=RequestMethod.GET)
	public ModelAndView getPurchaseOrders() {
		
		List<PurchaseOrder> pos=sellerService.getPurchaseOrders();
		
		ModelAndView mv=new ModelAndView("PurchaseOrders");
		mv.addObject("pList", pos);
		return mv;
	}
	
	@RequestMapping(value = "/getAllBuyers", method = RequestMethod.GET)
	public String getAllBuyers(ModelMap map) {
		
		map.addAttribute("buyerDetails", userService.getAllBuyers()); 
		
		return "ViewAllBuyers"; 
	}
	
	@RequestMapping(value = "/viewProductsSeller", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {
		
		map.addAttribute("productDetails", productService.viewAllProducts());
		
		return "ViewProductsSeller";
	}
}
