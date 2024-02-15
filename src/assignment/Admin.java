package assignment;

import java.util.List;

public class Admin extends Account{

	public Admin(String user_name, String user_password, String user_email, String role) {
		super(user_name, user_password, user_email);
		this.role = role;		
	}
	
	//delete worker account
	public void deleteAccount(String ID){
		List<String[]> accountList = loadData();

	    for(String[] account : accountList){
	        if (account[3].equals(ID)){
	            for(int i = 0; i < account.length; i++){
	            	account[i] = "";
	                }
	            }
	        }    
	    overwriteData(accountList);
	}		

	
	//edit worker account
	public String editProfile(String[] updatedProfile,String ID) {
		List<String[]> accountList = loadData();
		for (String[] account: accountList) {
			if(account[3].equals(ID)) {
	            for (int i = 0; i < account.length; i++) {
	                account[i] = updatedProfile[i];
	            }
	            break;
	         }
		}

		return overwriteData(accountList);
	}
}
