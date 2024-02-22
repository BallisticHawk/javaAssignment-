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


	public String[] generateInvoice(String ID) {
		Sales obj1 = new Sales();
		String[] invoiceDetails = obj1.searchSales(ID);
		
		//calculate total price by using price * quantity
        double price = Double.parseDouble(invoiceDetails[3]);
        int quantity = Integer.parseInt(invoiceDetails[4]);
        double total_price = price * quantity;
        invoiceDetails[6] = String.valueOf(total_price);
	
		
		
		return invoiceDetails;
	}





}
