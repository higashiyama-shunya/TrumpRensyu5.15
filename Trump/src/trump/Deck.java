package trump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import trump.Card.Mark;

public class Deck {
	//フィールド
	//2023.5.17フィールド変数がpublicだったのでprivateに変更
	private final List<Card> cards = new ArrayList();
	//コンストラクタ

	public Deck() {
		//配列をリストにするメソッドasListを使用してmarksリストを作成。
		List<Card.Mark> marks = Arrays.asList(
				Card.Mark.SPADE,
				Card.Mark.CLUB,
				Card.Mark.DIAMOND,
				Card.Mark.HEART);

		//上で作成したmarksリストを拡張for文でmarkに代入していく。
		for (Mark mark : marks) {
			for (int j = 1; j < 14; j++) {
				int k = j;
				Card card = new Card(k, mark); //代入したmarkと繰り返しのjでカードインスタンスの作成
				cards.add(card);
			}
		}

		Card card = Card.getJoker();
		cards.add(card);
		cards.add(card); //最後の方に追加するようにする
		Collections.shuffle(cards);
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

	//デッキを取得するgetter
	public List<Card> getCards() {
		return cards;
	}

}
