package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Sales extends FileClass{
	private int quantity,day,month,year;
	private String orderID, name, Salesperson_ID, productStatus, saleStatus, customerName, address, contact;
	private double price;
	
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
		String message;
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
	
	public String insertData(String[] rowData) {
		String message;
		try {
			FileWriter fw = new FileWriter(filename,true);
			PrintWriter outputFile = new PrintWriter(fw);

			for(String data : rowData) {
	        	outputFile.println(data);
	        }


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
            
            //the text file have 13 column (order id, item name, salesperson ID, price, quantity, day, month, year, saler status 
            //productstatus, customer name, customer address, customer contact


            while (inputFile.hasNext()){
             String[] saleDetail = new String[13];
             for(int i = 0; i < 13; i++){
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

					for(int i = 0; i < 13;i++) {
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
	
	public List<String[]> viewSales() {
		// TODO Auto-generated method stub
		Sales obj1 = new Sales();
		List<String[]> salesList = obj1.loadData();
		
		List<String[]> info = new ArrayList<String[]>();
		
		for(String[] sales : salesList) {
			//convert int day,month,year to date
			int year,month,day;
			day = Integer.parseInt(sales[5]);
			month = Integer.parseInt(sales[6]);

			year = Integer.parseInt(sales[7]);
	        LocalDate date = LocalDate.of(year,month,day);
	        
	        sales[5] = date.toString();
	        
	        info.add(sales); 
	        
		}
		
		
		return info;
	}
	
	//find particular order from the saleslist
	public String[] searchSales(String ID) {
		
		
		List<String[]> list = viewSales();
		
		
		for(String[] record : list) {
			
			//check if Order ID match with the input.
			if(record[0].equals(ID)) {

				return record;
			}
		}
		
		
		
		
		return null;
	}
	
	public List<String[]> generateReport(String year){
		
		//load all the sales
		List<String[]> salesList = viewSales();
        List<String[]> filteredSales = new ArrayList<>();
		String[] reportDetail = new String[15];

		for(String[] sales: salesList) {
			//if is in the selected year
			if(sales[7].equals(year)) {
				filteredSales.add(sales);
			}
		}
		
		
		
		
		return null;
		
	}
	public List<String[]> generateReport(String month, String year){
		
		int totalWorkDone, totalPendingProduct, totalInProgress, totalApproved, totalPendingSales, totalClosed;
		//load all the sales
		List<String[]> salesList = viewSales();
        
		//store the sales that match the selected month and year
		List<String[]> filteredSales = new ArrayList<>();
		for(String[] sales: salesList) {
			//if is in the selected year
			if(sales[7].equals(year) && sales[6].equals(month)) {
				filteredSales.add(sales);
			}
		}
		
		
		//calculate total number of each sales & product status
		
		for(String[] sales: filteredSales) {
			if(sales[8].equals("Pending")) {
				
			}
		}
		
        //format the report details
		//arrary column (title,
		String[] reportDetail = new String[15];
		reportDetail[0] = month + "/" + year;
		
		
		//product status
		reportDetail[1] = String.valueOf(totalPendingProduct);
		reportDetail[2] = String.valueOf(totalInProgress);
		reportDetail[3] = String.valueOf(totalWorkDone);
		
		//sales status
		reportDetail[4] = String.valueOf(totalPendingSales);
		reportDetail[5] = String.valueOf(totalApproved);
		reportDetail[6] = String.valueOf(totalClosed);
		
		
		//total of all sales
		reportDetail[7] = totalWorkDone + totalPendingProduct + totalInProgress + totalApproved + totalPendingSales + totalClosed;
		
		
		

		
		
		return filteredSales;
		
	}
	
}
