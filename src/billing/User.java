package billing;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class User {
	boolean isEmployee;
	boolean isAffiliate;
	Date joiningDate;
	public User(boolean isEmployee, boolean isAffiliate, Date joiningDate){
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.joiningDate = joiningDate;
	}
	//function to create new user from string
	//User details in the form isEmployee,isAffiliate,joiningDate
	public static User createUser(String input){
	    String[] substrings = input.split(",");
	    int numberOfFields =  User.class.getDeclaredFields().length;
	    if (substrings.length == numberOfFields){
	    	boolean isEmployee = Boolean.parseBoolean(substrings[0]);
	    	boolean isAffiliate = Boolean.parseBoolean(substrings[1]);
	    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    	Date newDate = null;
	    	try {
				newDate = df.parse(substrings[2]);
			} catch (ParseException e) {
				System.out.println("Date not in correct format");
			}
	    	//assign more fields here if new fields are added.
	    	User user = new User(isEmployee, isAffiliate, newDate);
	    	System.out.println("New User created - " + input);
	    	return user;
	    }
	    return null;
	}
}