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
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class modifyData {

	 public static void updateSalesData(List<String[]> tableData) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));
	             PrintWriter writer = new PrintWriter(new FileWriter("sales_temp.txt"))) {
	        	System.out.print(tableData);
	            String[] fileData = new String[13];
	            System.out.print(fileData);
	            int linesRead = 0;
	            String line;

	            while ((line = reader.readLine()) != null) {
	                fileData[linesRead % 13] = line.trim();
	                linesRead++;
	                if (linesRead % 13 == 0) {
	                    boolean matchFound = checkForUIDMatch(fileData, tableData);
	                    if (matchFound) {
	                        for (String rowData : tableData.get(linesRead / 13 - 1)) {
	                            writer.println(rowData);
	                        }
	                    } else {
	                        for (String rowData : fileData) {
	                            writer.println(rowData);
	                        }
	                    }
	                    writer.println(); // Add an empty line after each row
	                    fileData = new String[13];
	                }
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        // Rename the temporary file to the original file
	        try {
	            Files.move(Paths.get("sales_temp.txt"), Paths.get("sales.txt"), StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	 private static boolean checkForUIDMatch(String[] fileData, List<String[]> tableData) {
		    System.out.print(fileData);System.out.print(tableData);
		 String fileUID = fileData[2]; // Assuming the UID is located at index 2
		    for (String[] rowData : tableData) {
		        if (rowData[2].equals(fileUID)) {
		            return true; // Match found
		        }
		    }
		    return false; // No match found
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