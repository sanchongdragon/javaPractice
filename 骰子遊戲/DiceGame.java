package java1223;

import java.util.ArrayList;

public class DiceGame {
	// 使用ms950預設編碼寫註解
	static boolean win = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �إ� Player ����
		GameRule player = new Player();
		// �إ� Computer ����
		GameRule computer = new Computer();
		// ��������Ƥj�p
		if(player.calcScore()<computer.calcScore()) {
			System.out.println("�q�����");
		}else{
			System.out.println("���a���");
		}		
	}

}
abstract class GameRule{
	// �إ� ArrayList ���O���� "dice" 
	ArrayList<Integer> dice = new ArrayList<>();
	// �ŧi�ܼ�
	boolean done = false;
	int rnd = 0, score = 0;
	// ��H��k calcScore ���l���Ooverride����
	abstract int calcScore();
}