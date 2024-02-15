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
	//@Override
	public String insertData() {
		
		String message = "start";
        //load the list of account
		List<String[]> accountList = loadData();
        
        //check if the email exists
        for(String[] account : accountList) {
        	if(account[0].equals(user_email)) {
        		System.out.println(account[0]);
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
	}


