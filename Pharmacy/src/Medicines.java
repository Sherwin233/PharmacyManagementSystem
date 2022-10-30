public class Medicines {
	private String itemName;
	private int itemCode, itemStock;
	private double itemQty, itemPrice;
	Medicines(int itemCode,String itemName,double itemPrice,int itemStock){
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemStock = itemStock;
	}
	public int getItemCode() {
		return this.itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return this.itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return this.itemStock;	
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String toString() {
		return itemCode + "" + itemName + "" + itemQty + "" + itemPrice;
	}
}