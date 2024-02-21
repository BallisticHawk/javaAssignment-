package assignment;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dataReader {
    
    public DefaultTableModel displayProduct() {
        DefaultTableModel model = new DefaultTableModel();
        
        // Add headers to the model
        model.addColumn("Item ID");
        model.addColumn("Item Name");
        model.addColumn("Category");
        model.addColumn("Price");
        model.addColumn("Sellable Online");
        model.addColumn("Short Description");
        model.addColumn("Designer");
        model.addColumn("Depth");
        model.addColumn("Height");
        model.addColumn("Width");
        
        try (FileReader fr = new FileReader("product.txt");
             BufferedReader br = new BufferedReader(fr)) {
            
            Object[] lines = br.lines().toArray();
            
            for (Object line : lines) {
                String[] parts = line.toString().split(",");
                model.addRow(parts);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return model;
    }
    
    public DefaultTableModel displaySales() {
        DefaultTableModel model = new DefaultTableModel();

        // Add headers to the model
        model.addColumn("uuid");
        model.addColumn("name");
        model.addColumn("Salesperson_ID");
        model.addColumn("price");
        model.addColumn("quantity");
        model.addColumn("day");
        model.addColumn("month");
        model.addColumn("year");
        model.addColumn("saleStatus");
        model.addColumn("productStatus");
        model.addColumn("customerName");
        model.addColumn("address");
        model.addColumn("contact");

        try (FileReader fr = new FileReader("sales.txt");
             BufferedReader br = new BufferedReader(fr)) {
            
            String[] parts = new String[13]; // Array to store each column data for a row
            
            int lineCount = 0; // Counter to keep track of lines read
            String line;
            while ((line = br.readLine()) != null) {
                parts[lineCount % 13] = line.trim(); // Store each line in the corresponding position in the array
                lineCount++;

                // If 13 lines have been read (representing one row), add them as a row to the model
                if (lineCount % 13 == 0) {
                    // Check if the Salesperson_ID matches the Account.UID attribute
                    if (parts[2].equals("e879e184-6dbb-4335-b29a-f8785192d638123")) {
                        model.addRow(parts);
                    }
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return model;
    }
}
