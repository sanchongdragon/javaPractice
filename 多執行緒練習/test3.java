package java0106;
/*
  弘里的扣
  */
public class test3 {

	public static void main(String[] args) {
		Son son = new Son();
		son.start();
	}

}


class Mom extends Thread {
	public void run() {
		for(int i = 1;i<=15;i++)
		{
			try {
				sleep(300);
				System.out.printf("�������a���F %d ����\n",i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 1;i<=10;i++)
		{
			try {
				sleep(300);
				System.out.printf("�����N���N�F %d ����\n",i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Son extends Thread{
	public void run() {
		Mom mom = new Mom();
		mom.start();
		try {
			sleep(300);
			System.out.printf("�p�W�^�a�S\n");
			sleep(300);
			System.out.printf("�p�W�ڨ���\n");
			mom.join();
			System.out.printf("�p�W���Y\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}