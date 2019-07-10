package com.tara.model;

public class ItemBean {
	
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	private String itemImage;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	@Override
	public String toString() {
		return "ItemBean [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity="
				+ itemQuantity + ", itemImage=" + itemImage + "]";
	}
	
	

}
