package assignment;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;

public class addProduct {
	protected String itemId;
	public String name;
	public String category;
	public String price;
	public String sellableStatus;
	public String shortDesc;
	public String designer;
	public String depth;
	public String height;
	public String width;
	
	
	public addProduct (String itemId, String name, String category, String price, String sellableStatus, String shortDesc, String designer, String depth, String height, String width)
	{
	    itemId = this.itemId;
	    name = this.name;
	    category = this.category;
	    price = this.price;
	    sellableStatus = this.sellableStatus;
	    shortDesc = this.shortDesc;
	    designer = this.designer;
	    depth = this.depth;
	    height = this.height;
	    width = this.width;
	}


	public String writeProduct(String itemId, String name, String category, String price, String sellableStatus, String shortDesc, String designer, String depth, String height, String width)
	{
	    try {
				FileWriter fw = new FileWriter("product.txt", true);
	            PrintWriter outputFile = new PrintWriter(fw);
	            outputFile.print(itemId + ",");
	            outputFile.print(name + ",");
	            outputFile.print(category + ",");
	            outputFile.print(price + ",");
	            outputFile.print(sellableStatus + ",");
	            outputFile.print(shortDesc + ",");
	            outputFile.print(designer +",");
	            outputFile.print(depth +",");
	            outputFile.print(height +",");
	            outputFile.print(width +",");         
	            outputFile.println();
	            outputFile.close();
	            return "Success";
	            
	        }
	        catch (Exception ex)
	        {
	            return ex.toString();
	            
	        }
	}
	
}



 

