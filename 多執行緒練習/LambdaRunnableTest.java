package java0106;

public class LambdaRunnableTest {
	static float turtlescore = 0, rabbitscore = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 利用lambda override runnable "turtle"的run method
		Runnable turtle = () -> {
			while (turtlescore < 20) {
				turtlescore++;
				System.out.println("烏龜跑 " + turtlescore + " 公尺");
				try {
					// sleep要搭try catch
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		// 做出一個thread a 並將override過的turtle runnable放入
		Thread a = new Thread(turtle);
		// 利用lambda override runnable "rabbit"的run method
		Runnable rabbit = () -> {
			while (rabbitscore < 20) {
				rabbitscore += 2;
				System.out.println("兔子跑 " + rabbitscore + " 公尺");
				int x = (int) ((Math.random() * 10) + 1);
				if (x % 2 == 0) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		// 做出一個thread b 並將override過的turtle runnable放入
		Thread b = new Thread(rabbit);
		// 啟動a,b thread 
		a.start();
		b.start();

	}

}
