package java0120;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("123.txt");
		int cnt = 0;
		if (file.exists()) {
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter brw = new BufferedWriter(fw);
				while (cnt++ < 5) {
					brw.write(Integer.toString((int) (Math.random() * 100) + 1));
					brw.newLine();
					brw.flush();
				}
				brw.close();
				fw.close();
				FileReader fr = new FileReader(file);
				BufferedReader bfr = new BufferedReader(fr);
				int a = 0;
//				while ((a = bfr.read()) != -1) {
////					bfr.wait(100);
//					System.out.print((char)a);
//				}
				String str = null;
				while ((str = bfr.readLine()) != null) {
//					bfr.wait(100);
					System.out.println(str);
				}

				bfr.close();
				fr.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println(file.getAbsolutePath());

	}

}
