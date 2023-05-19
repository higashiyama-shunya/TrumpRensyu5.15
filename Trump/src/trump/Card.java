package trump;

import java.util.ArrayList;
import java.util.List;

public class Card {
	//フィールド
	private int Number;
	private Mark mark;

	//enumメソッド
	//
	public enum Mark {
		JOKER("ジョーカー", 5), SPADE("スペード", 4), HEART("ハート", 3), DIAMOND("ダイヤ", 2), CLUB("クラブ", 1);

		private final String name;
		private final int priority;

		private Mark(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}

	};

	//コンストラクタ
	public Card(int number, Mark mark) {
		this.Number = number;
		this.mark = mark;
	}

	//メソッド
	//NumberとMarkを取得するメソッド
	public String getNumber() {
		return Integer.toString(this.Number);
	}

	public String getMark() {
		return this.mark.name;
	}

	//大小を比較するメソッド
	public int compareTo(Card anotherCard) {
		return this.getPower() - anotherCard.getPower();
	}

	//リストを昇順にソートするメソッド
	public static List<Card> sortList(List<Card> cardList) {
		int num = cardList.size();
		List<Card> sortList = new ArrayList();
		for (int i = 0; i < num; i++) {
			Card maxCard = Card.getMaxCard(cardList);
			sortList.add(maxCard);
			cardList.remove(maxCard);
		}
		return sortList;
	}

	//マークや数字の値から出されるパワーを返すメソッド
	public int getPower() {
		int power = 0;

		if (Number == 1) {
			//ACEを14に設定
			power = 14;
		} else {
			power = Number;
		}

		power = power * 10 + mark.priority;

		return power;
	}

	public int getNum() {
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
		} else if (this.Number == 1) {
			return "エース";
		} else {
			return Integer.toString(this.Number);
		} //このメソッドを新しく作るのではなく、本来のgetNumberに追加した書いたほうがメソッドが少なくなって分かりやすい。
	}

	//マークと数字を同時に表示するメソッド
	public String markAndNum() {
		if (this.mark == Mark.JOKER) {
			return this.mark.name;
		} else {
			return this.mark.name + "の" + this.getNewNumber();
		}
	}

	//渡されたカードのリストから最大値をとるメソッド 途中
	public static Card getMaxCard(List<Card> hands) {
		Card maxCard = new Card(0, Mark.CLUB);
		for (Card card : hands) {
			int compare = card.compareTo(maxCard);
			if (0 < compare) {
				maxCard = card;
			}
		}
		return maxCard;
	}

	//ジョーカーを生成するメソッド
	public static Card getRedJoker() {
		Card card = new Card(16, Mark.JOKER);
		return card;
	}

	public static Card getBlackJoker() {
		Card card = new Card(15, Mark.JOKER);
		return card;
	}

	//ワンペア判定を行うメソッド 修正　戻り値をHandのクラス型で返す。
	public static Hand isOnePair(List<Card> cardList) {
		Hand hand;
		int allPower = 0;
		List<Card> cl = new ArrayList(); //まず空のカードリストを作成
		List<Card> pairCard = new ArrayList(); //ペアのカードを入れるリストを作成
		boolean isJoker = false;

		Card maxCard = Card.getMaxCard(pairCard);
		Card joker = new Card(0, Mark.CLUB);

		for (Card c : cardList) {
			cl.add(c); //playerが持っているリストを拡張for文で回して空のリストに追加していく
			if (c.mark == Mark.JOKER) {
				isJoker = true;
				joker = c;
			}
		}

		if (!isJoker) {
			for (int i = 0; i < cl.size(); i++) { //for文でiを0から回す
				Card card = cl.get(i); //i番にあるカードを生成
				for (int j = i + 1; j < cl.size(); j++) { //forでjをi+1から回す　※iの次に来るカードはi+1で出てそれより前のカードはもう判定されている
					Card card2 = cl.get(j); //j番にあるカードを取得
					if (card.getNum() == card2.getNum()) { //if文でカードの数値が一致した場合
						cl.remove(i); //合っていた2枚ののカードを削除
						cl.remove(j - 1); //j-1のカードは上のremoveで消えて数値が1ずれるため-1している。
						pairCard.add(card);
						pairCard.add(card2);

					}
				}
			}
		} else {
			pairCard.add(maxCard);
			pairCard.add(joker);
		}
		for (Card c : pairCard) {
			int power = c.getPower();
			allPower = allPower + power;
		}

		return hand = new Hand(allPower, cl);
	}

	//ツーペア判定を行うメソッド 修正版
	public static Hand isTwoPair(List<Card> cardList) {
		int allPower = 0;
		List<Card> cl = new ArrayList(); //リストを複製して入れるための空のリスト
		List<Card> pairCard = new ArrayList(); //ペアを入れる空のリスト
		List<Card> jokerList = new ArrayList(); //ジョーカーを入れる空のリスト
		int power = 0;
		int power2 = 0;
		Hand hand;

		boolean isJoker = false;

		//カードリストの複製とジョーカーが入っているか判定し、入っていたらジョーカーリストに入れる。
		for (Card c : cardList) {
			cl.add(c);
			if (c.mark == Mark.JOKER) {
				jokerList.add(c);
			}
		}
		Card.sortList(cl);

		if (jokerList.size() == 1) {
			Hand hand1 = Card.isOnePair(cl);
			if (hand1.getPower() > 0) {
				allPower = hand1.getPower() + cl.get(0).getPower() + jokerList.get(0).getPower();
			}
		} else if (jokerList.size() == 2) {
			Hand hand1 = Card.isOnePair(cl);
			if (hand1.getPower() > 0) {
				allPower = hand1.getPower() + cl.get(0).getPower() + jokerList.get(0).getPower();
			} else {
				for (int i = 0; i < jokerList.size(); i++) {
					allPower += cl.get(i).getPower() + jokerList.get(i).getPower();
				}
			}
		} else if (jokerList.size() == 0) {
			Hand hand1 = Card.isOnePair(cl);
			if (hand1.getPower() > 0) {
				Hand hand2 = Card.isOnePair(hand1.getCardList());
				if (hand2.getPower() > 0) {
					allPower = hand1.getPower() + hand2.getPower();
				}
			}
		}
		return hand = new Hand(allPower, cl);
	}

	//スリーカードを判定するメソッド作成
	public static int isThreeCard(List<Card> cardList) {
		int allPower = 0;
		List<Card> cl = new ArrayList(); //空のカードリストclの作成
		List<Card> trioCard = new ArrayList(); //3カードがあった場合、入れるリスト。
		for (Card c : cardList) { //まず拡張for文でplayerが持っているリストを空のリストに複製していく。
			cl.add(c);
		}

		loop: for (int i = 0; i < cl.size(); i++) {
			Card card = cl.get(i);
			for (int j = i + 1; j < cl.size(); j++) {
				Card card2 = cl.get(j);
				if (card.getNum() == card2.getNum()) {
					for (int k = j + 1; k < cl.size(); k++) {
						Card card3 = cl.get(k);
						if (card2.getNum() == card3.getNum()) {
							trioCard.add(card);
							trioCard.add(card2);
							trioCard.add(card3);
							break loop;
						}
					}
				}
			}
		}
		for (Card c : trioCard) {
			allPower = allPower + c.getPower();
		}
		return allPower;
	}
}
