package utility;

import java.util.regex.Pattern;

public class CheckPattern {
	
	
	
	public static boolean checkLogin(String username)
	{
		
		boolean f=false;
		
		if(username.length() >= 8)
		{
			if(Pattern.matches(".*[!\"#$%&'()*+-./:;<=>?@^_{}~].*", username))
			{
				return false;
			}
			
			else
			{
				return true;
			}
		}
		
		return f;
		
	}
	
	public static boolean checkPassword(String password)
	{
		
		boolean f=false;
		int count=0;
		
		if(password.length() == 10)
		{
			
			if(Pattern.matches(".*[a-z].*", password))
				  count++;
			  if(Pattern.matches(".*[A-Z].*", password))
				  count++;
			  if(Pattern.matches(".*[0-9].*", password))
				  count++;
			  if(Pattern.matches(".*[!\"#$%&'()*+-./:;<=>?@^_{}~].*", password))
				  count++;
			  
			  if(count==4)
				  return true;
			
		}
		
		return f;
		
	}

}
