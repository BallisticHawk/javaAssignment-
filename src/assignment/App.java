package assignment;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		student.status = Student.Status.JUNIOR;
		Admin obj1 = new Admin("Jia Ming","test","test123456@gmail.com","Officer");
		String message = obj1.insertData();
		System.out.println(message);
        
	
	}

}
