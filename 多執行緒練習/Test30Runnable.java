package java0106;

public class Test30Runnable {
	int i=0;
			// 使用lambda語法 override Runnable 介面中的run method
			// 變數名為 clear
			Runnable clear = () -> {
				// override runnable 內的 run method
				try {
					// 媽媽掃地過了15分鐘
					for (int i = 1; i <= 15; i++) {
						Thread.sleep(100);
						System.out.printf("過了 %d 分鐘\n", i);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// exception 發生時處理動作
					System.out.println("媽媽累了想休息");
				}
			};
			
			// 使用lambda語法 override Runnable 介面中的run method
			// 變數名為 makeRice
			Runnable makeRice = () -> {
				// override runnable 內的 run method
				try {
					// 媽媽煮飯過了10分鐘
					for (int i = 1; i <= 10; i++) {
						Thread.sleep(100);
						System.out.printf("過了 %d 分鐘\n", i);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					// exception 發生時處理動作
					System.out.println("媽媽累了想休息");
				}
			};
			// 使用lambda語法 override Runnable 介面中的run method
			// 變數名為 momRunnable 為媽媽的動作
			Runnable momRunnable = () ->{
				System.out.println("幫小明開門");
				System.out.println("媽媽開始掃地");
				// 將override Runnable run method 的兩個變數丟入thread中 
				Thread clearT = new Thread(clear);
				Thread makeRiceT = new Thread(makeRice);
				// 啟用掃地的thread
				clearT.start();
				System.out.println("正在執行的Thread有 "+Thread.activeCount()+"個");
				try {
					// 執行掃地thread直到完成
					clearT.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println("媽媽開始煮飯");
					// 啟用煮飯thread
					makeRiceT.start();
					System.out.println("正在執行的Thread有 "+Thread.activeCount()+"個");
					try {
						// 執行煮飯thread直到完成
						makeRiceT.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			Runnable mingAction = () -> {
				System.out.println("小明到家");
				System.out.println("小明等吃飯");
				System.out.println("//-----------------------");

//				Mother mom = new Mother();
//				mom.start();
				// 將override Runnable run method 的變數momRunnable丟入thread中 
				Thread momThread = new Thread(momRunnable);
				// 啟用 momThread 
				momThread.start();
				System.out.println("正在執行的Thread有 "+Thread.activeCount()+"個");
				try {
					// 執行momThread直到完成
					momThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("小明吃飯飯");
			};
}
