package java0106;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Runnable aa = () -> {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		};
//		Thread a = new Thread(aa);
//		Runnable bb = () -> {
//			System.out.println("5秒鐘到囉");
//		};
//		Thread b = new Thread(bb);
//		// 啟動a thread
//		a.start();
//		try {
//			// a.join為 a thread做完後在開始後續的thread
//			a.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("123123");
//		b.start();
//		System.out.println("123123");

		Father fa = new Father();
		fa.start();
		
	}

}

class Father extends Thread {
	@Override
	public void run() {
		System.out.println("回家");
		System.out.println("洗澡");
		System.out.println("不能洗澡");
		System.out.println("打電話");
		System.out.println("等瓦斯");
		workman wm = new workman();
		wm.start();
		try {
			wm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("洗澡");
	}
}

class workman extends Thread {
	@Override
	public void run() {
		System.out.println("接到電話");
		System.out.println("出去送瓦斯");

		try {
			for (int i = 1; i <= 5; i++) {
				sleep(1000);
				System.out.println("過了"+i+"秒");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("發生意外");
		}

	}
}
