package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Officer extends Account implements ManageSales{

	public List<String[]> modifySales(List<String[]> salesList, String OrderID,String status) {
		
		//for loop on the sale list to find the selected order ID and change the sale status.
		for (String[] sale: salesList) {
			if(sale[0].equals(OrderID)) {
				sale[8] = status;
	            break;
	         }
		}		
		
		
		return salesList;
	}
	
	public List<String[]> modifySales(List<String[]> salesList, String OrderID,String saleStatus, String productStatus) {
		
		//for loop on the sale list to find the selected order ID. Besides make sure that the orderID is approval only able to allow make changes of product status.
		for (String[] sale: salesList) {
			if(sale[0].equals(OrderID) && saleStatus.equals("approval")) {
				sale[9] = productStatus;
	            break;
	         }
		}		
		
		
		return salesList;
	}	

	@Override
	//find particular order from the saleslist
	public String[] searchSales(List<String[]> salesList,String ID) {
		
		List<String[]> list = viewSales(salesList);
		
		
		for(String[] record : list) {
			
			//check if Order ID match with the input.
			if(record[0].equals(ID)) {

				return record;
			}
		}
		
		
		
		
		return null;
	}
	public String[] generateInvoice(List<String[]> salesList,String ID) {
		String[] invoiceDetails = searchSales(salesList,ID);
		
		//calculate total price by using price * quantity
        double price = Integer.parseInt(invoiceDetails[3]);
        double quantity = Integer.parseInt(invoiceDetails[4]);
        double total_price = price * quantity;
        invoiceDetails[6] = String.valueOf(total_price);
	
		
		
		return invoiceDetails;
	}

	public List<String[]> viewSales(List<String[]> salesList) {
		// TODO Auto-generated method stub
		
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
	

}
