package java0113;

public class MultipleThreadSyschronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account(10000);
		Machine u1 = new Machine(ac,15000);
		Machine u2 = new Machine(ac,2000);
		Machine u3 = new Machine(ac,3300);
		u1.start();
		u2.start();
		u3.start();
		try {
			u1.join();
			u2.join();
			u3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Account{
//	private String acName;
	private int acBalance;
	public Account(int acBalance) {
		this.acBalance = acBalance;
	}
	public void setacBalance(int change) {
		this.acBalance = change;
	}
	public int getacBalance() {
		return acBalance;
	}
}
class Machine extends Thread{
	private int money;
	static int balance;
	public Machine (Account ac,int money) {
		balance = ac.getacBalance();
		this.money = money;
	}
	
	public synchronized static void get(int cnt) {
		if(balance-cnt>=0) {
			balance -= cnt;
			System.out.printf("提款 : %d 元，餘額 : %d 元\n",cnt,balance);
		}
		else
			System.out.printf("餘額不足\n");
	}
	
	public synchronized static void in(int cnt) {
			balance += cnt;
			System.out.printf("存款 : %d 元，餘額 : %d 元\n",cnt,balance);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if((int)(Math.random()*2)+1 == 1)
			get(money);
		else
			in(money);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}