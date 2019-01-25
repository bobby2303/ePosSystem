public class Banking
{
	public String bankingDate;	//Date of banking record
	public String bankingTotalNet;	//Total money made from Z report
	public String bankingFloat;	//Float in till from Z report
	public String bankingMisc;	//Misc sales from Z report
	public String bankingCash;	//Cash total sales from Z report
	public String bankingCreditCard;	//Credit Card total sales from Z report
	public String bankingTotalMoney;	//Total money  from Z report
	public String bankingProfit;	//Profit made from sales
	
	public String toString()
	{
		String combined = (bankingDate + "," + bankingTotalNet + "," + bankingFloat + "," + bankingCash + "," + bankingCreditCard + "," + bankingMisc + "," +  bankingTotalMoney + "," + bankingProfit);
		return combined;//combine items data into single string
	}

}