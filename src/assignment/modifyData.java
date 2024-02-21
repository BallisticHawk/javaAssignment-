package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class modifyData {

	public void updateSalesData(DefaultTableModel model) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter("sales.txt"))) {
	        int rowCount = model.getRowCount();
	        int colCount = model.getColumnCount();
	        int linesWritten = 0;

	        // Loop through each row of the JTable
	        for (int i = 0; i < rowCount; i++) {
	            // Loop through each line (13 lines) of the row in the text file
	            for (int j = 0; j < 13; j++) {
	                // Get the data for each cell from the JTable
	                String cellData = "";
	                if (j < colCount) {
	                    cellData = String.valueOf(model.getValueAt(i, j));
	                }
	                // Write the data to the text file
	                writer.println(cellData);
	                linesWritten++;
	            }
	            // If it's not the last row and we've written more than 13 lines, add an empty line after each row
	            if (i < rowCount - 1 && linesWritten % 14 == 0) {
	                writer.println();
	                linesWritten = 0; // Reset line counter after adding an empty line
	            }
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
    public void deleteRow(DefaultTableModel model, int rowToDelete) {
        // Remove the row from the table model
        model.removeRow(rowToDelete);
        // After removing the row, update the sales.txt file
        updateSalesData(model);
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