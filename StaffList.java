import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class StaffList
{
	Staff[] theStaff = new Staff[10]; //New staff array of 10 items (members)
	int nextFreeLocation = 0; //nextFreeLocation in array, start at 0
	public boolean userFound = false; //Boolean variable for used found when reading from file
	public String currentUser; //Hold the username of logged user
	public ImageIcon largeLogo;	//ImageIcon of original user profile picture
	public ImageIcon smallLogo;	//Image icon of user profile picture after re-sizing.
	public String tempLine;		//tempLine of line read from Staff.txt
	public boolean updateUserFound = false; //Boolean variable for used found when reading from file
	public String encryptedString;	//public encryptedString  
	public String decryptedString;	//public decryptedString
	String key = "Bar12345Bar12345";	//Key for encryption
	SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");	//Setup SecretKeySpec using key set previously
			
	
	public void addStaff(Staff tempStaff)
	{
		theStaff[nextFreeLocation] = tempStaff;	//Add newStaff to array before writing to file
		nextFreeLocation++;	//Increase nextFreeLocation within array
		System.out.println("Staff added to Staff[]");	
	}
	
	public void writeToFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Staff.txt",true)); //Write to Staff.txt
			for(int i=0;i<nextFreeLocation;i++) //For all array positions to nextFreeLocation
			{
				bw.write(theStaff[i].toString());	//Convert array position to single string and write to file
				bw.newLine();	//Add new line for next item to be written
			}
			bw.close(); //Close bufferedWriter after all members written to file
		}
		
		catch(Exception e)
		{
			System.out.println("ERROR WRITING TO FILE" + e);
		}
		
	}
	
	
	public void readFromFileLogin(String username, String password) //readFromFile using for Login, pass in parameters of username and password
	{
		userFound = false; //Set boolean of userFound to false when user attempts to login
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Staff.txt")); //Read from Staff.txt
			String line = br.readLine(); 	//Temporary variable to hold line read from text value
			while(line!=null)	//Read from file when line is not empty
			{
				String[] tempArray = line.split(",");	//Split current line by , into temporary array
				String correctUsername = tempArray[0];	//Set variable correctUsername = first item in array
				currentUser = tempArray[0];				//Set current user to username = first item in array
				String encryptedPass = tempArray[1];	//The encrypted password is read from the text file
				String correctPassword = decryptString(encryptedPass);	//The password is decrypted and set to correctPassword
				
				largeLogo = new ImageIcon(tempArray[4]); //Set variable largeLogo to index of image = fifth item in array
				
				if((correctUsername).equals(username))	//If username entered (login screen) matched correctUsername
				{
					System.out.println("Username found in Staff.txt");
					if((correctPassword).equals(password))	//If password entered (login screen) matched correctPassword
					{
						System.out.println("Password correct in Staff.txt");
						userFound = true;	//Set userFound = true as user has been matched with correct login details
						break;	//Break while loop						
					}
				}				
				
				line = br.readLine(); //If username is not on the first line, read next line in file
				
				if(line=="") //When line is empty, break loop, user is not in the file
				{
					System.out.println("NO");
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR LOGIN" + e);
		}
	
	
	}
	
	
	public void reSizeProfilePicture()	//Re-size profile picture of user, so its suitable for the system
	{
		Image largeLogoImg = largeLogo.getImage(); //Get original image
		Image smallLogoImg = largeLogoImg.getScaledInstance(100,100,0); //Resize image to 100 x 100
		smallLogo = new ImageIcon(smallLogoImg);	//Set smallLogo ImageIcon as re-sized image, to be used within system
	}
	
	public void readFromFile(String textFile, String searchValue)//readFromFile , pass in parameters of file and searchValue(item to be searched)
	{
		updateUserFound = false;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(textFile));	//Read from  text file
			tempLine = br.readLine();	//Set up temporary variable for first line read from text file
			while(tempLine!=null)	//While line is not empty
			{
				String[] tempArray = tempLine.split(",");	//Split the line into an array
				System.out.println(tempArray[0] + "=" + searchValue);
				if(tempArray[0].equals(searchValue))	//If the username = searchVakue
				{
					updateUserFound = true;
					System.out.println("Item found in Staff.txt "+ tempLine);
					break;		//...Break loop
				}
				
				tempLine = br.readLine(); //...Else read next line
				
				
			}
			
		}
		catch(Exception exc)
		{
			System.out.println("not" + exc);
		}
				
		
	}
	
	public void wipeStaffFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Staff.txt"));	//Overwrite Staff.txt
			bw.write("");	//With "" (null)
			bw.close();		//Close Writer
		}
		catch(Exception e)
		{
			System.out.println("ERROR WIPING FILE " + e);
		}
		
	}
	
	public void updateStaffPasswordFile()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("tempStaffFile.txt"));	//Setup tempStaffFile.txt reader
			BufferedWriter bw = new BufferedWriter(new FileWriter("Staff.txt"));			//Setup writer to Staff.txt
			String tempLine = br.readLine();												//tempLine is the first line read from tempStaffFile.txt
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
	
	public String encryptString(String text)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES");	//Setup cipher of instance AES
			
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);	//Encryption mode with aesKey
			byte[] encrypted = cipher.doFinal(text.getBytes());	//Get bytes of original text
			Base64.Encoder encoder = Base64.getEncoder();	//Convert text to base64 encrypted text
			encryptedString = encoder.encodeToString(encrypted);	//Encryption takes place
			System.out.println(encryptedString);					//Output
			
		}
		catch(Exception exc)
		{
			System.out.println("haha" + exc);
		}
		
		return encryptedString;		//Return encryption text
	}
	
	public String decryptString(String encryptedText)
	{
		try		
		{
			Cipher cipher = Cipher.getInstance("AES");	//Setup cipher of instance AES
			
			Base64.Decoder decoder = Base64.getDecoder();	//Encryption mode with aesKey
			cipher.init(Cipher.DECRYPT_MODE, aesKey);	
			decryptedString = new String(cipher.doFinal(decoder.decode(encryptedText)));	//Get bytes of encrypted text and decrypt text using AESkey.
			System.out.println(decryptedString);
		}
		catch(Exception exc)
		{
			System.out.println("haha" + exc);
		}
		
		return decryptedString;	//Return decrypted text
		
	}
	
	
	//Items
	
	
	







}