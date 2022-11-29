package order.receipt.items;

public class Item {
	private int item_qty; 
	private String item_name; 
	private double item_price;
	// initially set the flag value to False
	private boolean itemExempted= false;
	private boolean itemImported= false;
	/**
	 * Item class contains the properties for every item in orders
	 * 
	 */

	
	public Item(int qty, String name, double price){
		this.item_qty = qty;
		this.item_price = price;
		this.item_name = name;
       
    }

	public int getItem_qty() {
		return item_qty;
	}

	public void setItem_qty(int item_qty) {
		this.item_qty = item_qty;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public boolean isItemExempted() {
		return itemExempted;
	}

	public void setItemExempted(boolean itemExempted) {
		this.itemExempted = itemExempted;
	}

	public boolean isItemImported() {
		return itemImported;
	}

	public void setItemImported(boolean itemImported) {
		this.itemImported = itemImported;
	}
	
	

}
