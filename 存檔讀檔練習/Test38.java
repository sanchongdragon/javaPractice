package java0120;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream in = new FileInputStream("01.mp4");
			FileOutputStream out = new FileOutputStream("02.mp4");
			
			
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
