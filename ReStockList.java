import java.io.*;
import java.util.*;

public class ReStockList
{
	ReStock[] theReStock = new ReStock[1000];	//New staff array of 1000 items (products)
	int nextFreeLocation = 0;//nextFreeLocation in array, start at 0
	public String line; //Temporary variable to hold read data from text file
	
	public void addReStockItem(ReStock tempReStock)
	{
		theReStock[nextFreeLocation] = tempReStock;//Add newReStock to array before writing to file
		nextFreeLocation++;//Increase nextFreeLocation within array
		System.out.println("ReStock Item added to ReStock[]");	
	}
	
	public void writeToFile()
	{
		//Create ReStock.txt based on item quantities within Items.txt
		try
		{
			File reStockFile = new File("ReStock.txt");	//Declare new file variable
			boolean a = reStockFile.delete();			//Delete existing ReStock.txt
			BufferedReader br = new BufferedReader(new FileReader("Items.txt"));	//Read items text file
			line = br.readLine();	//Temporary variable to hold line read from text value
			while(line != null) 	//Read from file when line is not empty
			{
				String[] dataRead = line.split(",");	//Split current line by , into temporary array
				String quantity = dataRead[2];				//String quantity set to relevant array position
				String reStockQuantity = dataRead[3];		//String reStockQuantity set to relevant array position
				
				int iReStockQuantity = Integer.parseInt(reStockQuantity);	//Convert Strings to Integers
				int iQuantity = Integer.parseInt(quantity);
				if((iReStockQuantity) > (iQuantity))	//For all values with a ReStockQuantity greather than the current quantity
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter("ReStock.txt",true));	//Setup new BufferedWriter to ReStock.txt
					bw.write(line);	//Write the current line to ReStock.txt				
					bw.newLine();	//Add new line
					bw.close();		//Close the BufferedWriter
					line = br.readLine();	//Read next line in Items.txt
					System.out.println("New items in restock.txt");
				}
				else
				{
					System.out.println("FALSE");
					line = br.readLine();	//If first line is not to be written onto ReStock.txt, read next line and repeat process
				}	
				if(line=="")
				{	
					break;	//Repeat loop till all items in items.txt have been checked, break loop
				}
				
			}
		}
		catch(IOException exc)
		{
			System.out.println("not" + exc);
			exc.printStackTrace();
		}
		
	}
	
	public void readFromFile(String textFile, String searchValue)//readFromFile , pass in parameters of file and searchValue(item to be searched)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(textFile));	//Read from text file
			line = br.readLine();	//Set up temporary variable for first line read from text file
			while(line!=null)	//While line is not empty
			{
				if(line.contains(searchValue))	//If the line contains the data from the clicked cell...
				{
					System.out.println("Item found in Items.txt"+ line);
					break;		//...Break loop
					
				}
				
				line = br.readLine(); //...Else read next line
				
				if(line=="")	//If line is empty
				{
					break; //Break loop, item isnt in text file
				}
			}
			
		}
		catch(Exception exc)
		{
			System.out.println(exc);
		}
				
		
	}







}