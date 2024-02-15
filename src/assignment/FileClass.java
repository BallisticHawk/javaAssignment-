package assignment;


public abstract class FileClass {
	
	
	protected String filename;
	public FileClass(String filename) {
		this.filename=filename;
	}
	
	
	public abstract String insertData();

}
