package java0106;
/**
 * Test30
 * Test33
 * */

public class Test30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 生成Test30Runnable class的物件 runnable
		Test30Runnable runnable = new Test30Runnable();
		// 將runnable內的Runnable 介面 "mingAction" 放入Thread中
		Thread mingThread = new Thread(runnable.mingAction);
		// run method為執行內容，start method才是啟動thread
		// 啟用mingThread
		mingThread.start();
		// 顯示目前執行的thread數量 activeCount method
		System.out.println("正在執行的Thread有 "+Thread.activeCount()+"個");
	}
}