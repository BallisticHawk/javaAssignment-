package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Officer extends Account implements ManageSales{

	@Override
	public String modifySales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchSales() {
		// TODO Auto-generated method stub
		return null;
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
