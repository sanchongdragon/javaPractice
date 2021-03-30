package java1223;

import java.util.Collections;

public class Player extends GameRule {
	// 使用ms950預設編碼寫註解
	@Override
	int calcScore() {
		
		// TODO Auto-generated method stub
		while (!done) {
			for (int j = 0; j < 4; j++) {
				rnd = (int) (Math.random() * 6) + 1;
				dice.add(rnd);
			}
			// 
			Collections.sort(dice);
//			Collections.frequency(dice, o);
			for (int i = 0; i < 6; i++) {
//				if (dice.indexOf(i) == dice.lastIndexOf(i)) {
				if(Collections.frequency(dice, i)<=1) {
					continue;
//				} else if (Math.abs((dice.indexOf(i) - dice.lastIndexOf(i))) == 2) {
				}else if(Collections.frequency(dice, i)==3) {
					break;
//				} else if(Math.abs((dice.indexOf(i) - dice.lastIndexOf(i))) == 1){
				}else if(Collections.frequency(dice, i)==2){
					System.out.println("���a:"+dice);
					dice.remove(dice.indexOf(i));
					dice.remove(dice.indexOf(i));
					score = dice.get(0) + dice.get(1);
					System.out.println("�I��:"+score);
					done = true;
					break;
				}
				else {
					System.out.println("���a:"+dice);
					dice.remove(dice.indexOf(i));
					dice.remove(dice.indexOf(i));
					score = 999;
					System.out.println("�I��:"+score);
					done = true;
					break;
				}
			}
			dice.clear();
		}
		return score;
	}
	
}
