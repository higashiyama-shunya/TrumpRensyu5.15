package trump;

import java.util.List;

public class Hand {
	//フィールド
	private int power;
	private List<Card> cardList;

	//コンストラクタ
	public Hand(int power, List<Card> cardList) {
		this.power = power;
		this.cardList = cardList;
	}

	//メソッド
	public int getPower() {
		return power;
	}

	public List<Card> getCardList() {
		return cardList;
	}

}
