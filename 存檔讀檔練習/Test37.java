package java0120;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream in = new FileInputStream("03.jpg");
			FileOutputStream out = new FileOutputStream("04.jpg");
			
			
			byte[] a = new byte[in.available()];
			in.read(a);
			out.write(a);
			in.close();
			out.close();
			System.out.println("copy success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
