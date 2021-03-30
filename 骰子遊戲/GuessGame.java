package java1223;

import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cgame cg = new Cgame();
		cg.gs();
	}

}

abstract class Guess{

	void conPt() {;}
	void gs() {;}

	
}
class Cgame extends Guess{
	

	@Override
	public void gs() {
		// TODO Auto-generated method stub
		boolean result = true;
		int ans = (int)(Math.random()*10) + 1;
		int num = 0;
		Scanner scn = new Scanner(System.in);
		while(result) {
			conPt();
			num = scn.nextInt();
			if(num == ans)
				result = false;
			else
				System.out.print("²q¿ù¤F\n");
		}
		scn.close();
	}

	@Override
	public void conPt() {
		// TODO Auto-generated method stub
		System.out.print("¿é¤J¼Æ¦r:\n");
	}
}