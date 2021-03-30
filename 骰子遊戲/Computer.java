package java1223;

import java.util.Collections;

public class Computer extends GameRule {
	// 使用ms950預設編碼寫註解
	@Override
	int calcScore() { //�мg�����O�� method
		// TODO Auto-generated method stub
		while (!done) { 
			//���X 4 �� 1-6 ����ƨ� add �i ArrayList ���O���� "dice" ��
			for (int j = 0; j < 4; j++) {
				rnd = (int) (Math.random() * 6) + 1;
				dice.add(rnd);
			}
			// �ϥζ��X���O�ӹ� "dice" �� sort �Ƨ�
			Collections.sort(dice);
			for (int i = 0; i < 6; i++) {
				// �P�_ "dice" �� i ���X�{�����ޤ� i �̫�X�{������
				// ex: 1,2,3,3
//				if (dice.indexOf(i) == dice.lastIndexOf(i)) {
				if(Collections.frequency(dice, i)<=1) {
					// �ǰt�۵��ΨS�����ƹL�A�h continue �]�U�@�ӼƦr
					continue;
//				} else if (Math.abs((dice.indexOf(i) - dice.lastIndexOf(i))) == 2) {
				}else if(Collections.frequency(dice, i)==3) {
					// �ǰt���ެۮt 2 ��A�Y�O�X�{�L 3 ��
					// ex: 1,1,1,3
					break;
//				} else if(Math.abs((dice.indexOf(i) - dice.lastIndexOf(i))) == 1){
				}else if(Collections.frequency(dice, i)==2){
					// �ǰt���ެۮt 1 ��A�Y�X�{�L 2 ��
					System.out.println("�q��:"+dice);
					// �����e 2 �ӯ���
					dice.remove(dice.indexOf(i));
					dice.remove(dice.indexOf(i));
					// ���X�Ѿl 2 �ӼƦr�A�íp�����
					score = dice.get(0) + dice.get(1);
					System.out.println("�I��:"+score);
					// �]�mdone�ܼƸ���L���j��
					done = true;
					break;
				}
				else {
					System.out.println("�q��:"+dice);
					dice.remove(dice.indexOf(i));
					dice.remove(dice.indexOf(i));
					// �p�G 4 ��Ʀr�ҬۦP�h�����԰�����
					score = 999;
					System.out.println("�I��:"+score);
					done = true;
					break;
				}
			}
			// �M�� ArrayList ���O���� "dice"
			dice.clear();
		}
		// �^�� score �P�_�j�p
		return score;
	}
}
