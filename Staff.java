public class Staff
{
	public String username; //Username of staff member
	public String password; //Password of staff member
	public String securityQuestion; //Security question of staff member
	public String securityQuestionAnswer; //Security question of staff member answer
	public String profilePicture; //Profile picture location of staff member answer

	public String toString()
	{
		String combined = (username + "," + password + "," + securityQuestion + "," + securityQuestionAnswer + "," + profilePicture);
		return combined; //Combine staff member data into single string
	}

}