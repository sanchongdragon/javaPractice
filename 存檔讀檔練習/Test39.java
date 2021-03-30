package java0120;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
1. 假定帳號為user，密碼為010101，並存於某資料夾中。
2. 建立程式讀取帳號密碼。
3. 若正確，顯示歡迎，帳號錯誤回應"帳號錯誤"，密碼錯誤回應"密碼錯誤"
 * */
public class Test39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("passwd.txt");
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(file));
			Scanner scn = new Scanner(System.in);
			String[] str = new String[2];
			System.out.println("請輸入帳號: ");
			str[0] = scn.next();
			System.out.println("請輸入密碼: ");
			str[1] = scn.next();

			String temp;
			int cnt = 0;
			while ((temp = bfr.readLine()) != null) {
				String[] res = temp.split(":");

				switch (res[0]) {

				case "acc" -> {
					if (!res[res.length - 1].equals(str[0])) {
						System.out.println("帳號輸入錯誤");
						break;
					}else {
						cnt++;
					}
				}
				case "pwd" -> {
					if (!res[res.length - 1].equals(str[1])) {
						System.out.println("密碼輸入錯誤");
						break;
					}else {
						cnt++;
					}
				}

				}
			}
			if(cnt == 2)
				System.out.println("welcome to my boring test txt");

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
