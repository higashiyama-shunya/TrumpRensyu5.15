package trump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	//フィールド
	public List<Card> cards = new ArrayList();
	//コンストラクタ

	public Deck() {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				String mark;
				if (i == 0) {
					mark = "スペード";
				} else if (i == 1) {
					mark = "クラブ";
				} else if (i == 2) {
					mark = "ハート";
				} else {
					mark = "ダイヤ";
				}
				int k = j;
				if (k == 11) {

				}
				Card card = new Card(k, mark);
				cards.add(card);
			}
		}
		Card card = new Card(14, "ジョーカー");
		cards.add(card);
		cards.add(card); //最後の方に追加するようにする
	}

	//メソッド
	//シャッフルするメソッド
	public void shuffle() {
		Collections.shuffle(cards);
	}

	//カードを引くメソッド
	public Card draw() {
		if (cards.size() != 0) {
			int cardLast = cards.size() - 1;
			Card card = cards.get(cardLast);
			cards.remove(cardLast);
			return card;
		} else {
			return null;
		}
	}

	//カードを一番上に置くメソッド
	public void put(Card card) {
		cards.add(card);
	}

}
