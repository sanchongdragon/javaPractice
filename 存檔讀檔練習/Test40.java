package java0120;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 建立 File 物件，檔名為test.txt
		// 如找不到此檔案則建立此檔案
		File file = new File("test.txt");
		try {
			// 建立scanner物件
			Scanner scn = new Scanner(System.in);
			// 建立 BufferedWriter 物件 argument 代入 FileWriter 物件， true為不斷寫入，而非覆蓋
			// 預設為覆蓋
			BufferedWriter bfw = new BufferedWriter(
								 new FileWriter(file,true));
			// 建立 string 物件
			String str = new String();
			// 用str物件來接scanner的值
			// 當只輸入q時中斷輸入
			while(!(str = scn.nextLine()).equals("q")) {
				// BufferedWriter 不斷寫入 str 的內容
				bfw.write(str);
				// BufferedWriter 做換行動作
				bfw.newLine();
			}
			// 關閉 BufferedWriter
			bfw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
