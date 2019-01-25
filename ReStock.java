public class ReStock
{
	public String itemCode;	//Item code of item
	public String itemName;	//Item name of item
	public int iQuantity;	//Quantity of item
	public int iReStockQuantity;	//Re-stock quantity of item
	public double originalPrice;	//Bought price of item
		
	public String toString()
	{
		String combined = (itemCode + "," + itemName + "," + iQuantity + "," + iReStockQuantity + "," + originalPrice);
		return combined; //combine restock data into single string
	}
	
	
	
	
	
	







}