public class Sales
{
	public int saleID;			//ID of sale made
	public String saleDateTime;	//Date and time of sale
	public String saleItemCode;	//Item code of item sold in sale
	public String saleItemName;	//Item name of item sold in sale
	public int saleQuantity;	//Quantity of item sold
	public double saleSubTotal;	//Subtotal from sale
	public double saleTotalPrice;	//Total price of a sale
	

	public String toString()
	{
		String combined = (saleID + "," + saleDateTime + "," + saleItemCode + "," + saleItemName + "," +  saleQuantity + "," + saleSubTotal + "," + saleTotalPrice);
		return combined;	//Combine sales details into a single string
	}

}