package trump;

import java.util.ArrayList;
import java.util.List;

public class Card {
	//フィールド
	private int Number;
	private String Mark;
	private int Priority;

	//コンストラクタ
	public Card(int number, String mark) {
		this.Number = number;
		this.Mark = mark;
		if (mark.equals("ジョーカー")) {
			this.Priority = 5;
		} else if (mark.equals("スペード")) {
			this.Priority = 4;
		} else if (mark.equals("ハート")) {
			this.Priority = 3;
		} else if (mark.equals("ダイヤ")) {
			this.Priority = 2;
		} else if (mark.equals("クラブ")) {
			this.Priority = 1;
		}

	}

	//メソッド
	//NumberとMarkを取得するメソッド
	public String getNumber() {
		return Integer.toString(this.Number);
	}

	public String getMark() {
		return this.Mark;
	}

	//大小を比較するメソッド
	public int compareTo(Card anotherCard) {
		if (Integer.compare(this.Number, anotherCard.getPower()) == 0) {
			return Integer.compare(this.Priority, anotherCard.Priority);
		}
		return Integer.compare(this.Number, anotherCard.getPower());
	}

	//数値を代わりにintとして渡すメソッド
	public int getPower() {
		return this.Number;
	}

	//11以上の数値を文字表現にして返すメソッド
	public String getNewNumber() {
		if (this.Number == 11) {
			return "ジャック";
		} else if (this.Number == 12) {
			return "クイーン";
		} else if (this.Number == 13) {
			return "キング";
		} else if (this.Number >= 14) {
			return "ジョーカー";
		} else {
			return Integer.toString(this.Number);
		} //このメソッドを新しく作るのではなく、本来のgetNumberに追加した書いたほうがメソッドが少なくなって分かりやすい。
	}

	//マークと数字を同時に表示するメソッド
	public void markAndNum() {
		System.out.println(this.Mark + "の" + this.Number);
	}

	//ジョーカーを生成するメソッド
	public static Card getJoker() {
		Card card = new Card(99, "ジョーカー");
		return card;

	}

	//ワンペア判定を行うメソッド
	public static List<Card> isOnePair(List<Card> cardList) {
		List<Card> cl = new ArrayList(); //まず空のカードリストを作成
		List<Card> pairCard = new ArrayList(); //ペアのカードを入れるリストを作成

		for (Card c : cardList) {
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
					if (count == 1) {
						pairCard.add(card);
						pairCard.add(card2);
					}
				}
			}
		}
		return pairCard;
	}

	//ツーペア判定を行うメソッド
	public static List<Card> isTwoPair(List<Card> cardList) {
		List<Card> cl = new ArrayList();
		List<Card> pairCard = new ArrayList();
		for (Card c : cardList) {
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
					pairCard.add(card);
					pairCard.add(card2);
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
					pairCard.add(card);
					pairCard.add(card2);
				}
			}
		}
		return pairCard;
	}

	//スリーカードを判定するメソッド作成
	public static boolean isThreeCard(List<Card> cardList) {
		List<Card> cl = new ArrayList(); //空のカードリストclの作成
		for (Card c : cardList) { //まず拡張for文でplayerが持っているリストを空のリストに複製していく。
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

}
