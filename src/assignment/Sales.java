package assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sales extends FileClass{
	int quantity,day,month,year;
	String orderID, itemID, name, Salesperson_ID, productStatus, saleStatus;
	double price;
	
	
	public Sales(String filename) {
		super("sales.txt");
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public String insertData() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String[]> loadData() {
        try{
            List<String[]> saleDetails = new ArrayList<>();
            // using whileloop to load the file into an array list
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);
            
            //the text file have 11 column (order id, item id, item name, price, quantity, day, month, year, salesperson id, product status and sale status

            while (inputFile.hasNext()){
             String[] saleDetail = new String[11];
             for(int i = 0; i < 11; i++){
            	 saleDetail[i] = inputFile.nextLine();

             }
             saleDetails.add(saleDetail);
               
            }
            inputFile.close();

            return saleDetails;
        }catch (IOException e){
            return null;
        }
	}




	@Override
	public String overwriteData(List<String[]> updatedData) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
