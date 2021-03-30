package java0120;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 產生10組大樂透號碼(7個1-49之間的數字)，將這10組號碼寫入指定的檔案中
 * */
public class Test41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0; // 計次數
		File file = new File("daletou.txt"); // 建立 File 物件，指定path為daletou.txt
		try {
			// 建立 BufferedWriter 物件，內部代入FileWriter(path為file)
			BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
			// 產生10組大樂透數字
			while (cnt++ < 10) {
				// 取出每組亂數數字
				for (int x : rand()) {
					System.out.printf("%d\t", x);
					// 利用 BufferedWriter 物件 bfw 寫進file裡
					bfw.write(x + "\t");
				}
				// 換行
				bfw.newLine();
				
				System.out.println("");
			}
			// 關閉 BufferedWriter 物件
			bfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static int[] rand() {
		// 宣告陣列存放7個數字
		int[] arr = new int[7];
		// 建立AL物件
		ArrayList<Integer> al = new ArrayList<>();
		int cnt = 0, randnum = 0, item = 0;
		while (cnt < 7) {
			// 取亂數
			randnum = (int) (Math.random() * 49) + 1;
			// 重複則重取，不重複則add進AL物件
			if (!al.contains(randnum)) {
				al.add(randnum);
				cnt++;
			} else
				continue;
		}
		// 將AL物件內部值丟入arr陣列內
		while (item < al.size())
			arr[item] = al.get(item++);
		// 排序arr陣列小到大
		Arrays.sort(arr);
		return arr;
	}
}
