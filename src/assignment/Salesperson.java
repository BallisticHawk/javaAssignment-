package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Salesperson extends Account implements ManageSales{
	
	public void deleteSales(String OrderID) {
		Sales obj1 = new Sales();
		
		List<String[]> saleList = obj1.loadData();

	    for(String[] sale : saleList){
	        if (sale[0].equals(OrderID)){
	            for(int i = 0; i < sale.length; i++){
	            	sale[i] = "";
	                }
	            }
	        }    
	    obj1.overwriteData(saleList);	
	    
	    }
	
	public DefaultTableModel viewPersonalSales(String UID) {
		// TODO Auto-generated method stub
		Sales obj1 = new Sales();
		List<String[]> salesList = obj1.loadData();
		System.out.println(salesList);

		
        DefaultTableModel model = new DefaultTableModel();

        // Add headers to the model
        model.addColumn("Order ID");
        model.addColumn("Name");
        model.addColumn("Salesperson_ID");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Day");
        model.addColumn("Month");
        model.addColumn("Year");
        model.addColumn("Sales Status");
        model.addColumn("Product Status");
        model.addColumn("Customer Name");
        model.addColumn("Address");
        model.addColumn("Contact");
		
		
		for(String[] sales : salesList) {
			//Store the sales that match the salesperson UID
			if(sales[2].equals(UID)) {
		        model.addRow(sales);
		        
			}
	        
		}
		
		
		return model;
	}

	@Override
	public List<String[]> modifySales(List<String[]> salesList, String OrderID, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
