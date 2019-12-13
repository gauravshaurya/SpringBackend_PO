package com.iris.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iris.models.PurchaseOrder;
import com.iris.models.PurchaseOrderItems;
import com.iris.services.ProductService;
import com.iris.services.PurchaseOrderItemsService;
import com.iris.services.PurchaseOrderService;
import com.iris.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PurchaseOrderController {
	
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	PurchaseOrderService purchaseOrderService;
	@Autowired
	PurchaseOrderItemsService purchaseOrderItemsService;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/createPurchaseOrder/{buyerId}",method=RequestMethod.POST)
	public ResponseEntity<?> createPurchaseOrder(@PathVariable(name="buyerId") int buyerId, @RequestBody List<PurchaseOrderItems> purchaseOrderItemsList) {
		PurchaseOrder poObj=new PurchaseOrder();
		poObj.setBuyerObj(userService.getBuyer(buyerId));
		poObj.setSellerObj(userService.getSeller());
		poObj.setStatus("Forwarded to seller");
		
		for(PurchaseOrderItems obj:purchaseOrderItemsList) {
			obj.setProductObj(productService.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(poObj);
		}
		poObj.setPurchaseOrderItemsObj(purchaseOrderItemsList);
	
		purchaseOrderService.createPurchaseOrder(poObj);
		if(poObj!=null) {
			return new ResponseEntity<PurchaseOrder>(poObj,HttpStatus.OK);
		}
		else return new ResponseEntity<String>("Create PO failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/viewPurchaseOrders")
	public ResponseEntity<?> viewPurchaseOrders() {
		List<PurchaseOrder> list=purchaseOrderService.getPurchaseOrders();
		if(list.size()!=0) {
			return new ResponseEntity<List<PurchaseOrder>>(list,HttpStatus.OK);
		}
		return new ResponseEntity<String>("No purchase order found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/viewPoItems")
	public ResponseEntity<?> viewPoItems(@RequestParam(name="poId") int poId) {
		List<PurchaseOrderItems> poItemsList = purchaseOrderItemsService.getPoItemsById(poId);
		return new ResponseEntity<List<PurchaseOrderItems>>(poItemsList, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/purchaseOrderSeller", method = RequestMethod.GET)
//	public String purchaseOrderSeller(ModelMap map) {
//		System.out.println(purchaseOrderService.getPurchaseOrders());
//		map.addAttribute("purchaseOrders", purchaseOrderService.getPurchaseOrders());
//		
//		return "PurchaseOrderSeller"; 
//	}
//	
//	@RequestMapping(value = "/purchaseOrderVendor", method = RequestMethod.GET)
//	public String purchaseOrderVendor(ModelMap map) {
//		System.out.println(purchaseOrderService.getPurchaseOrders());
//		map.addAttribute("purchaseOrders", purchaseOrderService.getPurchaseOrders());
//		
//		return "PurchaseOrderVendor";
//	}

}