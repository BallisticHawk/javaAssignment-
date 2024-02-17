package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Sales extends FileClass{
	int quantity,day,month,year;
	String orderID, name, Salesperson_ID, productStatus, saleStatus, customerName, address, contact;
	double price;
	
	public Sales(String name, String SP,double price, int quantity, int day, int month, int year, String customerName, String address, String contact) {
		super("sales.txt");
		this.name = name;
		Salesperson_ID = SP;
		productStatus = "pending";
		saleStatus = "pending";
		this.price = price;
		this.quantity = quantity;
		this.day = day;
		this.month = month;
		this.year = year;
		this.customerName = customerName;
		this.address = address;
		this.contact = contact;
	}
	
	
	
	public Sales() {
		super("sales.txt");
		
		// TODO Auto-generated constructor stub
	}


	//insert new sales record
	@Override
	public String insertData() {
		String message = "hi";
		try {
			FileWriter fw = new FileWriter(filename,true);
			PrintWriter outputFile = new PrintWriter(fw);
			//generate unique ID for the order
	        UUID uuid = UUID.randomUUID();
			outputFile.println(uuid);
			outputFile.println(name);
			outputFile.println(Salesperson_ID);
			outputFile.println(price);
			outputFile.println(quantity);
			outputFile.println(day);
			outputFile.println(month);
			outputFile.println(year);
			outputFile.println(saleStatus);
			outputFile.println(productStatus);
			outputFile.println(customerName);
			outputFile.println(address);
			outputFile.println(contact);

			message = "Sales have been added";
			outputFile.close();
		}catch (IOException e) {
			message = "Unable to open file.";
			return message;
		}
	return message;
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
             String[] saleDetail = new String[13];
             for(int i = 0; i < 14; i++){
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



	//overwrite the textfile (used when performed delete / modification)

	@Override
	public String overwriteData(List<String[]> updatedData) {
		String message;
		try {
			FileWriter fw = new FileWriter(filename);
			PrintWriter outputFile = new PrintWriter(fw);
			for (String[] data: updatedData) {
				
                if (!"".equals(data[0])){

					for(int i = 0; i < 11;i++) {
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
	
}
