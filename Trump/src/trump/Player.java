package trump;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {
	//フィールド
	List<Card> list = new ArrayList();
	//コンストラクタ

	//メソッド
	public boolean isOnePair() {
		List<Integer> numList = new ArrayList();
		for (Card c : list) {
			numList.add(c.getPower());
		}
		List<Integer> numSet = new ArrayList(new HashSet<>(numList));

		if (numList.size() - numSet.size() == 1) {
			return true;
		}

		return false;
	}

	public boolean isTwoPair() {
		//スリーカードでもTrueを返してしまう。
		/*
		List<Integer> numList = new ArrayList();
		for (Card c : list) {
			numList.add(c.getPower());
		}
		List<Integer> numSet = new ArrayList(new HashSet<>(numList));
		
		if (numList.size() - numSet.size() == 2) {
			return true;
		}
		*/
		List<Integer> numList = new ArrayList();
		for (Card c : list) {
			numList.add(c.getPower());
		}
		int count = 0;
		for (int i = 0; i < numList.size(); i++) { //２回for文で回す。
			for (int j = i + 1; j < numList.size(); j++) { //numListの要素分回す
				if (numList.get(i) == numList.get(j)) { //２回目の初期値は１回目+1の値をつける。こうすることで前行った同じかどうかの判定だけがスキップできる
					count++;
				}
			}
		}
		if (count == 2) {
			return true;
		}
		return false;
	}

	public List<Card> changeCard(int cardIndex, Card card) {

		list.set((cardIndex - 1), card);

		return list;
	}
}
