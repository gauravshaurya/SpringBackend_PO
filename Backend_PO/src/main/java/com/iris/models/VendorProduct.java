package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vp")
public class VendorProduct {
	
	@Id
	@GeneratedValue
	@Column(name="vp_id")
	private int vpId;
		
	@Column(name="vendor_id")
	private int vendorId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="quantity")
	private int quantity;

	public int getVpId() {
		return vpId;
	}

	public void setVpId(int vpId) {
		this.vpId = vpId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
