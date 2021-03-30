package java0106;

public class Test29 {
	static int aa=0,bb=0;
	static boolean stop = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread a = new Thread() {
			@Override
			public void run() {
				while(!stop) {
					while(aa<20) {
						System.out.println("aa "+aa++);
						try {
							sleep((int)Math.random()*500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					stop  = true;
					break;
				}
			}
		};
		Thread b = new Thread() {
			@Override
			public void run() {
				while(!stop) {
					while(bb<20) {
						System.out.println("bb "+bb++);
						
						try {
							sleep((int)Math.random()*500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					stop = true;
					break;
				}
			}
		};
		
		a.start();
		b.start();
		
	}

}
