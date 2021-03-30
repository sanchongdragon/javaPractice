package java0120;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Test42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 建立 file 物件 ， path 為 相對路徑的 file.txt
		File file = new File("file.txt");
		// 建立 map 物件 
		Map<Character,Integer> map = new HashMap<>();
		// 往map裡面陸續丟入a-z
		for(char i = 97 ; i<=122;i++) {
			// 利用getOrdefault方法指定value
			map.put(i, map.getOrDefault(i, 0));
		}
		
		try {
			// 建立 BufferedReader 物件，代入 FileReader path為 file
			BufferedReader bfr = new BufferedReader(new FileReader(file));
			String str = "";
			// 當 bfr readLine != null
			while((str = bfr.readLine()) != null) {
				// str 轉小寫英文字母
				str = str.toLowerCase();
				// 取 str 轉成 charArray
				for(char x : str.toCharArray()) {
					// foreach if x 是空白，則continue
					if(x == ' ')
						continue;
					// if x 不是空白，則 put 進map 內部
					// 利用 getOrDefault 去存值
					map.put(x, map.getOrDefault(x, 0)+1);
				}
			}
			// 關閉 BufferedReader 物件
			bfr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception "+e);
		}
		for(char j = 97 ; j<=122;j++) {
			if(map.get(j) != 0) {
				// 遍歷 map 去尋找第幾個英文字母出現了幾次
				System.out.printf("英文字母 %s 出現了 %d 次\n",j,map.get(j));
			}
		}
//		map.forEach((k,v)->System.out.println("key="+k+" value="+v));
	}

}
