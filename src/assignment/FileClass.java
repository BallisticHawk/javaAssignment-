package assignment;

import java.util.List;

public abstract class FileClass {
	
	
	protected String filename;
	public FileClass(String filename) {
		this.filename=filename;
	}
	
	
	public abstract String insertData();
    public abstract List<String[]> loadData();
    public abstract String overwriteData(List<String[]> updatedData);

}


