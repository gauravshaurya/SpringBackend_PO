package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="tbl_product")
	public class Product {
		
		@Id
		@GeneratedValue
		@Column(name="product_id")
		private int productId;
		
		@Column(name="product_name", unique=true)
		private String productName;
		
		@Column(name="product_price")
		private double productPrice;

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
					+ "]";
		}
}
