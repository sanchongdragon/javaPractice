package java1230;

import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.*;
import javax.swing.*;

public class calendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
//		JFrame jFrame = new JFrame("Calendar月曆產生器");
//		JButton jbtn = new JButton("產生");
//		JTextArea jtxArea = new JTextArea();
//		JLabel jlbl2 = new JLabel("月曆產生處");
//		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
//		jFrame.setLocation(0, 0);
//		jFrame.setSize(500, 500);
//		var pane = jFrame.getContentPane();
//		pane.setBackground(Color.RED);
//		jFrame.setResizable(false);
//		jFrame.setVisible(true);
//		pane.add(BorderLayout.CENTER,jlbl2);
//		pane.add(BorderLayout.NORTH,jtxArea);
//		pane.add(BorderLayout.SOUTH,jbtn);
		

		// 宣告一個禮拜星期的陣列
		String[] dayOfWeek = {"","日","一","二","三","四","五","六"};
		// Calendar為抽象類別，利用提供的getInstance做實體化，同時取得當前時間
		Calendar calender = Calendar.getInstance();
		int year = 2020, month = 12;
		// 設定實體化的"calender"物件年份，月份，日期 
		calender.set(Calendar.YEAR, year);
		calender.set(Calendar.MONTH, month - 1);
		calender.set(Calendar.DATE, 1);
		// 宣告 strDay 來取得Calendar.DAY_OF_WEEK 常數
		// 這邊指的即是實體化的"calender"的date在一周當中的第幾天
		// p.s. 星期日為1 六為7
		var strDay = calender.get(Calendar.DAY_OF_WEEK);
		// 宣告 empty 用來當作補全上個月的天數
		var empty = 0;
		// 宣告 max 為當年當月最大天數
		var max = maxDayOfMonth(year, month);
//				
		for (int i = 1; i < 8; i++) {
			// 印出 日到六
			System.out.printf(dayOfWeek[i]+"\t");
		}
		// 插入換行符號
		System.out.println();
		// 補齊到開始日期前一天的天數
		while(empty++<strDay-1) {
			System.out.print("\t");
		}
		for(int j=1;j<=max;j++) {
			// 依序印出日期號碼並tab出間距
			System.out.print(j+"\t");
			// 如果天數為禮拜六則換行
			if(calender.get(Calendar.DAY_OF_WEEK)%7==0) {
				System.out.println();
			}
			// 天數+1天
			calender.add(Calendar.DATE, 1);
		}
	}

	static int maxDayOfMonth(int year, int month) {
		// 計算當年當月最大天數，須帶入年份及月份
		var max = 0;
		// 宣告 boolean 來判斷是否為閏年
		boolean leapYear = false;
//		calc.add(Calendar.MONTH, 1);
//		calc.roll(calc.get(Calendar.DATE), -1);
//		max = calc.get(Calendar.DATE);
		// 判斷閏年的條件式
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			leapYear = true;
		}
		if (leapYear) {
			// 如為閏年則最大天數帶入以下case
			max = switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> 31;
			case 4, 6, 9, 11 -> 30;
			default -> 29;
			};
		} else {
			// 如非閏年則最大天數帶入以下case
			max = switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> 31;
			case 4, 6, 9, 11 -> 30;
			default -> 28;
			};
		}
		// 回傳最大天數
		return max;
	}

}
