import java.io.*;
import java.util.*;

public class ItemList
{
	Items[] theItems = new Items[1000];	//New items array
	int nextFreeLocation = 0;	//nextFreeLocation in array, start at 0
	public String line;	//Temporary variable to hold read data from text file
	
	public void addItem(Items tempItem)
	{
		theItems[nextFreeLocation] = tempItem;	//Add newItem to array before writing to file
		nextFreeLocation++;		//Increase nextFreeLocation within array
		System.out.println("Item added to Items[]");	
	}
	
	public void writeToFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Items.txt",true));	//Write to Items.txt
			for(int i=0;i<nextFreeLocation;i++)		//For all array positions to nextFreeLocation
			{
				bw.write(theItems[i].toString());	//Convert array position to single string and write to file
				bw.newLine();	//Add new line for next item to be written
			}
			bw.close(); //Close writer
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR WRITING TO FILE" + e);
		}
		
	}
	
	public void readFromFile(String textFile, String searchValue)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(textFile));	//Read from items text file
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
	
	public void wipeItemsFile()	//Used to clear the items text file
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Items.txt"));	//Overwrite Items.txt
			bw.write("");	//With "" (null)
			bw.close();		//Close Writer
		}
		catch(Exception e)
		{
			System.out.println("ERROR WIPING FILE " + e);
		}
		
	}
	
	







}