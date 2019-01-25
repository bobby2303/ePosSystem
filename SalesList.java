import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import javax.swing.table.*;

public class SalesList
{
	Sales[] theSales = new Sales[1000];	//New staff array of 1000 items (products)
	int nextFreeLocation = 0;//nextFreeLocation in array, start at 0
	public String line; //Temporary variable to hold read data from text file
	public int salesID;	//ID of sale made
	public String sale;	//Sale details
	public boolean saleFound;	//Validation boolean if sale item found for relevant date
	
	public void addSales(Sales tempSales)
	{
		theSales[nextFreeLocation] = tempSales;//Add newItem to array before writing to file
		nextFreeLocation++;//Increase nextFreeLocation within array
		System.out.println("Sales added to Sales[]");	
	}
	
	public void writeToFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Sales.txt",true));	//Write to Sales.txt
		
			for(int i=0;i<nextFreeLocation;i++)//For all array positions to nextFreeLocation
			{
				bw.write(theSales[i].toString());//Convert array position to single string and write to file
				bw.newLine();//Add new line for next item to be written
				bw.close();//Close bufferedWriter after all sales written to file
				System.out.println("sales written to sales");
			}

		}		
		catch(Exception e)
		{
			System.out.println("ERROR WRITING TO FILE " + e);	
		}
		
	}

	
	public void readFromFile(String textFile, String searchValue, DefaultTableModel dtm)//readFromFile , pass in parameters of file and searchValue(item to be searched) and the table model
	{
		saleFound = false;	//Initally set saleFound to false
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(textFile));	//Read from  text file
			line = br.readLine();	//Set up temporary variable for first line read from text file
			while(line!=null)	//While line is not empty
			{
				if(line.contains(searchValue))	//If the line contains the data from the clicked cell...
				{
					System.out.println("Item found in " + textFile + line);
					dtm.addRow(line.split(","));	//Add the line to the model split by ","
					saleFound = true;
				}
				
				line = br.readLine(); //...Else read next line
				
				if(line=="")	//If line is empty
				{
					System.out.println("NO");
					break; //Break loop, item isnt in text file
				}
			}
			
		}
		catch(Exception exc)
		{
			System.out.println("not" + exc);
		}
		
		
	}
	
	public int createSalesID()
	{
		System.out.println("creating SalesID");
		salesID = 0;	//SalesID is initally 0
		try
		{
			File salesIDFile = new File("Sales.txt");	//File of Sales.txt
			BufferedReader br = new BufferedReader(new FileReader(salesIDFile));
			String sSaleID = br.readLine();	//Search Sales.txt
			while(sSaleID !=null)
			{
				String[] tempArray = sSaleID.split(",");	//Split line into tempArray[]
				int tempID = Integer.parseInt(tempArray[0]);	//Get sale ID from line using relevant tempArray position and assign value to tempID
				System.out.println("tempID is " + tempID);
				if(tempID>=salesID)	//If the tempID is greater than or equal to the salesID...
				{
					salesID = tempID + 1;	//Increase the salesID by 1
					
				}
				sSaleID = br.readLine();	//Read next line
				
											//This will repeat till the largest salesID has been found and the next salesID will be the following salesID
			}
			System.out.println(salesID);
			br.close();	//Close the reader
			
			
			
		}
		catch(Exception exc)
		{
			System.out.println("ERROR getting salesID " + exc);
		}
		
		return salesID;	//Return the salesID to write the next sale
	
	
	}
	
	public void updateItemsFileSale()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("tempItemsFile.txt"));	//Setup tempItemsFile.txt reader
			BufferedWriter bw = new BufferedWriter(new FileWriter("Items.txt"));			//Setup writer to Items.txt
			String tempLine = br.readLine();												//tempLine is the first line read from tempItemsFile.txt
			while(tempLine != null)		//While tempLine is not empty
			{
				bw.write(tempLine);		//Write the line to Items.txt
				System.out.println("writing temp line to file" + tempLine);
				bw.newLine();			//Add a new line
				tempLine = br.readLine();	//Read next line
				System.out.println("read next line");
			}
			br.close();	//Close reader
			bw.close();	//Close writer
		}
		catch(Exception e)
		{
			System.out.println("ERROR UPDATING FILE" + e);
		}
		

	}
	
	
	







}