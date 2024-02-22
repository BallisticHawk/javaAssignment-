package assignment;

import java.time.LocalDate;

public class Validation {
	 public static boolean validate(String input, String type) {
	        //check the type of checking
	        if(input == null){
	                return false;
	            }
	        
	        //allow A-Z only 
	        if (type == "name"){
	               if (!input.matches("[a-zA-Z\\s]+")){
	                   return false;
	               }
	               else{
	                   return true;
	               }
	            
	        }
	        
	        //allow email only contains "@"
	        else if(type == "email"){
	            if (!input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
	                return false;
	            }
	            else{
	                return true;
	            }

	           
	        }
	        return true;
	 
	        
	    
	}
	    //validate number must > 0
	    public static boolean validate(String input) {
	        //check not null and integer value only
	        if (input == null || !input.matches("\\d+") ) {
	            return false;
	        }
	        
	        //convert input to integer
	        int value = Integer.parseInt(input);

	        // check the input >= 0
	        if (value >= 1) {
	            return true;
	            
	        } 
	        
	        return false;
	    }    
	    
	    
	    //check date
	    public static Boolean validateDate(String day, String month, String year){
	    	
	        int intDay = Integer.parseInt(day);
	        int intMonth = Integer.parseInt(month);
	        int intYear = Integer.parseInt(year);

	        try {
	            LocalDate.of(intYear, intMonth, intDay);
	            return true; // If no exception is thrown, the date is valid
	        } catch (Exception e) {
	            return false; // If an exception is thrown, the date is not valid
	        }
	     
	    }
}
