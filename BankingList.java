import java.io.*;
import java.util.*;

public class BankingList
{
	Banking[] theBanking = new Banking[1000];	//New banking array
	int nextFreeLocation = 0;//nextFreeLocation in array, start at 0
	public String line; //Temporary variable to hold read data from text file
	public boolean dateFound;	//Boolean value for validation if date is found upon seaching
	
	public void addBanking(Banking tempBanking)
	{
		theBanking[nextFreeLocation] = tempBanking;//Add newBanking to array before writing to file
		nextFreeLocation++;//Increase nextFreeLocation within array
		System.out.println("Banking added to Banking[]");	
	}
	
	public void writeToFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Banking.txt",true));	//Write to Banking.txt
			for(int i=0;i<nextFreeLocation;i++)//For all array positions to nextFreeLocation
			{
				bw.write(theBanking[i].toString());//Convert array position to single string and write to file
				bw.newLine();//Add new line for next item to be written
			}
			bw.close();//Close bufferedWriter after all members written to file
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR WRITING TO FILE" + e);
		}
		
	}
	
	public void readFromFile(String textFile, String searchValue)	//readFromFile , pass in parameters of file and searchValue(item to be searched)
	{
		dateFound = false; //Initally set dateFound to false upon each search of a date
				
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(textFile));	//Read from text file
			line = br.readLine();	//Set up temporary variable for first line read from text file
			while(line!=null)	//While line is not empty
			{
				if(line.contains(searchValue))	//If the line contains the data from the clicked cell...
				{
					dateFound = true; //set itemFound to true
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
		
		if(searchValue == null)
		{
			dateFound = false;
		}
				
		
	}







}