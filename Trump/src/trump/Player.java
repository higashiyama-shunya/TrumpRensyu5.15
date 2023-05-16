package trump;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//フィールド
	//privateに変更してgetter/setter追加
	private List<Card> cardList = new ArrayList();
	//コンストラクタ

	//メソッド
	public boolean isOnePair() {
		/*
		List<Integer> numList = new ArrayList();
		for (Card c : cardList) {
			numList.add(c.getPower());
		}
		List<Integer> numSet = new ArrayList(new HashSet<>(numList));
		
		if (numList.size() - numSet.size() == 1) {
			return true;
		}
		*/

		List<Card> cl = new ArrayList(); //まず空のカードリストを作成
		for (Card c : this.cardList) {
			cl.add(c); //playerが持っているリストを拡張for文で回して空のリストに追加していく
		}

		int count = 0; //int型で0の変数countを宣言

		for (int i = 0; i < cl.size(); i++) { //for文でiを0から回す
			Card card = cl.get(i); //i番にあるカードを生成
			for (int j = i + 1; j < cl.size(); j++) { //forでjをi+1から回す　※iの次に来るカードはi+1で出てそれより前のカードはもう判定されている
				Card card2 = cl.get(j); //j番にあるカードを取得
				if (card.getPower() == card2.getPower()) { //if文でカードの数値が一致した場合
					cl.remove(i); //合っていた2枚ののカードを削除
					cl.remove(j - 1); //j-1のカードは上のremoveで消えて数値が1ずれるため-1している。
					count++; //count変数を1つ追加
				}
			}
		}
		if (count == 1) {
			return true; //countが1ならばtrueを返す。
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
				if (card.getPower() == card2.getPower()) {
					cl.remove(i);
					cl.remove(j - 1);
					count++;
					break loop;
				}
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

		if (count == 2) {
			return true;
		}
		return false;
	}

	public boolean isThreeCard() {
		List<Card> cl = new ArrayList(); //空のカードリストclの作成
		for (Card c : this.cardList) { //まず拡張for文でplayerが持っているリストを空のリストに複製していく。
			cl.add(c);
		}

		for (int i = 0; i < cl.size(); i++) {
			Card card = cl.get(i);
			for (int j = i + 1; j < cl.size(); j++) {
				Card card2 = cl.get(j);
				if (card.getPower() == card2.getPower()) {
					for (int k = i + 2; k < cl.size(); k++) {
						Card card3 = cl.get(k);
						if (card2.getPower() == card3.getPower()) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public List<Card> changeCard(int cardIndex, Card card) {

		cardList.set((cardIndex - 1), card);

		return cardList;
	}
}
