package Customer;

import java.util.List;

public abstract class File {
	
	
	protected String filename;
	public File(String filename) {
		this.filename=filename;
	}
	
	public abstract List<String[]> loadData();
	public abstract List<String[]> modifyData();
	public abstract List<String[]> searchData();
	public abstract String insertData();

}
