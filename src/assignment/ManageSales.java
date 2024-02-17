package assignment;

import java.util.List;

public interface ManageSales {
	List<String[]> modifySales(List<String[]> salesList, String OrderID,String status);
	
	String[] searchSales(List<String[]> salesList, String ID);
	
    List<String[]> viewSales(List<String[]> salesInfo);


}
