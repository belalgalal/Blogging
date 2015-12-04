package com.ithinkisink.model;

/**
 * 
 * @author Belal
 *
 */
public class Item {

	private String itemNo;
	private String description;
	private double unitCost;
	private int quantity;
	
	public Item(String itemNo, String description, double unitCost, int quantity) {
		super();
		this.itemNo = itemNo;
		this.description = description;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
