package assignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Account extends FileClass {
	enum user_role{
		Unassigned,
		Salesperson,
		Administrator,
		Officer,
	}	
	public String user_name;
	public String user_password;
	public String user_email;
	public static String UID;
	public String role;
	
	public Account(String user_name, String user_password, String user_email) {
		super("staffFile.txt");
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		role = "Unassigned";
	}
	public Account() {
		super("staffFile.txt");
	}
	
    public List<String[]> loadData(){
        try{
            List<String[]> accountDetails = new ArrayList<>();
            // using whileloop to load the file into an array list
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);
            
            //the text file have 5 column (email, password, name, UID, role)

            while (inputFile.hasNext()){
             String[] accountDetail = new String[5];
             for(int i = 0; i < 5; i++){
            	 accountDetail[i] = inputFile.nextLine();

             }
             accountDetails.add(accountDetail);
               
            }
            inputFile.close();

            return accountDetails;
        }catch (IOException e){
            return null;
        }
    }	
	@Override
    //insert new account into the text file.
	public String insertData() {
		
		String message = "start";
        //load the list of account
		List<String[]> accountList = loadData();
        
        //check if the email exists
        for(String[] account : accountList) {
        	if(account[0].equals(user_email)) {
        		message = "Account with this email is already created. Please try to create account with another email.";
        		return message;
        	}
        	
        }
        

		
        //Registered an account for the email if the email is not in the text file
			try {
				FileWriter fw = new FileWriter(filename,true);
				PrintWriter outputFile = new PrintWriter(fw);
				//generate unique ID
		        UUID uuid = UUID.randomUUID();

				outputFile.println(user_email);
				outputFile.println(user_password);
				outputFile.println(user_name);
				outputFile.println(uuid);
				outputFile.println(role);
				message = "Account have been registered.";
				outputFile.close();
			}catch (IOException e) {
				message = "Unable to open file.";
				return message;
			}
		return message;
			
		}
	//overwrite the entire text file.
	public String overwriteData(List<String[]> updatedData) {
		String message;
		try {
			FileWriter fw = new FileWriter(filename);
			PrintWriter outputFile = new PrintWriter(fw);
			for (String[] data: updatedData) {
				
                if (!"".equals(data[0])){

					for(int i = 0; i < 5;i++) {
						outputFile.println(data[i]);
					}
                }
			}
			outputFile.close();

			message = "Edited successfully.";
			return message;
		}catch (IOException e) {
			message = "Unable to open file.";
			return message;
		}
	}
	//login authentication.
	public String[] authenticateLogin(String providedEmail, String providedPassword) {
		List<String[]> accountList = loadData();
		String[] array = new String[3];
		//array index 1 is to store login status, index 2 is to store the message shown, index 3 is to store the user role
		
		
		for(String[] account : accountList) {
			//check if email exists
			if (providedEmail.equals(account[0])) {
			    // password correct and activated
			    if (providedPassword.equals(account[1]) && !account[4].equals("Unassigned")) {
			        // set the UID
			        UID = account[3];
			        array[0] = "success";
			        array[1] = "Successfully login";
			        array[2] = account[4];

			    }
			    // password incorrect
			    else if (!providedPassword.equals(account[1])) {
			    	array[0] = "fail";
			        array[1] = "Incorrect password";


			    }
			    // password correct but account not activated
			    else if (providedPassword.equals(account[1]) && account[4].equals("Unassigned")) {
			    	array[0] = "fail";
			        array[1] = "Account is not activated yet. Please contact admin to activate your account.";

			    }
			    return array;
			}


		}
	    array[0] = "fail";
	    array[1] = "Account with this email is not exists";
		return array;
	}
	
	//view personal profile
	public String[] viewProfile() {
		List<String[]> accountList = loadData();
		for(String[] account : accountList) {
			if (UID.equals(account[3])) {
				return account;
			}
		}
		return null;
	
	}
	
	//edit personal profile
	public String editProfile(String[] updatedProfile) {
		List<String[]> accountList = loadData();
		for (String[] account: accountList) {
			if(account[3].equals(UID)) {
	            for (int i = 0; i < account.length; i++) {
	                account[i] = updatedProfile[i];
	            }
	            break;
	         }
		}

		return overwriteData(accountList);
	}
	
	public void deleteAccount(){
		List<String[]> accountList = loadData();

	    for(String[] account : accountList){
	        if (account[3].equals(UID)){
	            for(int i = 0; i < account.length; i++){
	            	account[i] = "";
	                }
	            }
	        }    
	    overwriteData(accountList);
	    
	        

	}	
	

	
	
	}


