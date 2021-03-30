package java0120;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 將Hello Java字串放入資料流中，將資料流中的資料輸出至檔案
 * */
public class Test43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Test43.txt");
		String str = "Hello Java";
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
			bfw.write(str);
			bfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
