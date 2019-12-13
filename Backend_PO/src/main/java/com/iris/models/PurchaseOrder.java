package com.iris.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PurchaseOrderTab")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="Seller_Id")
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<PurchaseOrderItems> purchaseOrderItemsObj;
	
	private String status;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<PurchaseOrderItems> getPurchaseOrderItemsObj() {
		return purchaseOrderItemsObj;
	}

	public void setPurchaseOrderItemsObj(List<PurchaseOrderItems> purchaseOrderItemsObj) {
		this.purchaseOrderItemsObj = purchaseOrderItemsObj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", buyerObj=" + buyerObj + ", sellerObj=" + sellerObj
				+ ", purchaseOrderItemsObj=" + purchaseOrderItemsObj + ", status=" + status + "]";
	}

}