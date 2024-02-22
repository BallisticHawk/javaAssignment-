package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class modifyData {

	 public static void updateSalesData(List<String[]> tableData) {
	        
		 Sales obj1 = new Sales();
		 List<String[]> salesList = obj1.loadData();
		 	

		 
		 		//loop for edited data
		 		for(String[] data: tableData) {
		 			
		 			//loop for the file data
				 	for (String[] sale: salesList) {
				 		
				 		//if edited data's order id match file data's orderID
				 		if(data[0].equals(sale[0])) {
			                System.arraycopy(data, 0, sale, 0, data.length); // Copy data to sale
				 			break;
				 			
				 		}			 		
				 	}
		 			
		 			
		 		}


		 obj1.overwriteData(salesList);
				
				
			
	    }


	
    public void deleteRow(DefaultTableModel model, int rowToDelete) {
        // Remove the row from the table model
        model.removeRow(rowToDelete);
        // After removing the row, update the sales.txt file
        
    }
    
    public void updateProductData(DefaultTableModel model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("product.txt"))) {
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();

            // Loop through each row of the JTable
            for (int i = 0; i < rowCount; i++) {
                // Loop through each column of the row
                for (int j = 0; j < colCount; j++) {
                    // Get the data for each cell from the JTable
                    String cellData = String.valueOf(model.getValueAt(i, j));
                    // Write the cell data to the CSV file
                    writer.print(cellData);
                    // Add a comma if it's not the last column
                    if (j < colCount - 1) {
                        writer.print(",");
                    }
                }
                // Add a new line after each row
                writer.println();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
	
    public void deleteProductRow(DefaultTableModel model, int rowToDelete) {
        // Remove the row from the table model
        model.removeRow(rowToDelete);
        // After removing the row, update the sales.txt file
        updateProductData(model);
    }
}