public class Items
{
	public String itemCode;	//Item code of item
	public String itemName;	//Item name of item
	public int iQuantity;	//Quantity of item
	public int iReStockQuantity;	//Re-stock quantity of item
	public double originalPrice;	//Bought price of item
	public double salePrice;	//Sale price of item
	public double profitPrice;	//Profit made on item
	

	public String toString()
	{
		String combined = (itemCode + "," + itemName + "," + iQuantity + "," + iReStockQuantity + "," + originalPrice + "," + salePrice + "," + profitPrice);
		return combined; //combine items data into single string
	}
	

}