package assignment;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		student.status = Student.Status.JUNIOR;
		String message;
		Admin obj1 = new Admin("Jia Ming","test","test1234567@gmail.com","Officer");
		message = obj1.insertData();
		System.out.println(message);

		obj1.deleteAccount("9ce08166-6531-4a85-8213-5c60faa917ae");
		//obj1 = new Admin("Jia Ming","test","test123456@gmail.com","Officer");
		//message = obj1.authenticateLogin("test123456@gmail.com","test");
		//System.out.println(message);
        
		//String[] info = obj1.viewProfile();
		//System.out.println(Arrays.toString(info));
		
		
		///edit
        String[] new_info = new String[5];
		new_info[0] = "kali";
		new_info[1] = "kalipass";
		new_info[2] = "kaliname";
		new_info[3] = "3b256ab8-df0c-4af4-b790-c0cf02f29f65";
		new_info[4] = "Officer";

		obj1.editProfile(new_info,"3b256ab8-df0c-4af4-b790-c0cf02f29f65");
		//obj1.deleteAccount();
		
		
	}

}
