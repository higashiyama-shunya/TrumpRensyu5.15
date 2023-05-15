package trump;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {
	//フィールド
	//privateに変更してgetter/setter追加
	private List<Card> cardList = new ArrayList();
	//コンストラクタ

	//メソッド
	public boolean isOnePair() {
		List<Integer> numList = new ArrayList();
		for (Card c : cardList) {
			numList.add(c.getPower());
		}
		List<Integer> numSet = new ArrayList(new HashSet<>(numList));

		if (numList.size() - numSet.size() == 1) {
			return true;
		}

		return false;
	}

	public List<Card> getList() {
		return cardList;
	}

	public void setList(List<Card> list) {
		this.cardList = list;
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
		/*	こいつだとフルハウスがTrueになる
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
		*/

		List<Card> cl = new ArrayList();
		for (Card c : this.cardList) {
			cl.add(c);
		}

		int count = 0;

		loop: for (int i = 0; i < cl.size(); i++) {
			Card card = cl.get(i);
			for (int j = i + 1; j < cl.size(); j++) {
				Card card2 = cl.get(j);
				System.out.println(card.getMark() + card.getNewNumber());
				System.out.println(card2.getMark() + card2.getNewNumber());
				if (card.getPower() == card2.getPower()) {
					cl.remove(i);
					cl.remove(j - 1);
					count++;
					break loop;
				}
				System.out.println(count);
			}
		}

		for (int i = 0; i < cl.size(); i++) {
			Card card = cl.get(i);
			for (int j = i + 1; j < cl.size(); j++) {
				Card card2 = cl.get(j);
				if (card.getPower() == card2.getPower()) {
					cl.remove(i);
					cl.remove(j - 1);
					count++;
				}
			}
		}

		System.out.println(count);
		System.out.println("");
		for (Card c : cl) {
			System.out.println(c.getMark() + c.getNewNumber());
		}
		if (count == 2) {
			return true;
		}
		return false;
	}

	public boolean isThreeCard() {

		return false;
	}

	public List<Card> changeCard(int cardIndex, Card card) {

		cardList.set((cardIndex - 1), card);

		return cardList;
	}
}
