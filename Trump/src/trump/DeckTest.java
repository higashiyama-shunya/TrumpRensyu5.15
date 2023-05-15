package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

	Card card;
	Deck deck;
	List<Card> list;

	@BeforeEach
	public void setUp() {
		deck = new Deck();
	}

	@Test
	@DisplayName("カードの大小の比較をするメソッド")
	void test() {

		list = new ArrayList();
		List<Card> maxList = new ArrayList();

		for (int i = 0; i < 54; i++) {
			Card draw = deck.draw();
			list.add(draw);

		}

		Card max = new Card(0, "");

		for (Card c : list) {
			if (c.compareTo(max) == 1) {
				max = c;
			}
		}

		System.out.println("引いた54枚のカードは...");
		for (Card c : list) {
			System.out.print(c.getMark() + "の" + c.getNewNumber() + ",");
		}
		System.out.println("の5枚で、その中で最も強いカードは");
		System.out.println(max.getMark() + "の" + max.getNewNumber() + "です");

		//文字表現への変換は2つの方法で行った
		//1つはメインでif文を使って分岐をさせてNumberの文字列を対応する文字に変換
		//もう1つはクラス側で自身のNumberで新しくString型の値を取得する方法
	}

	@Test
	@DisplayName("Deckのカードを引くメソッドと置くメソッド")
	void test2() {
		System.out.println("デッキにカードを戻して引くと同じカードが出現する。");
		System.out.println("──開始──");
		System.out.println("カードを引きます");
		Card one = deck.draw();
		System.out.println("引いたカードは" + one.getMark() + "の" + one.getNewNumber() + "です");

		System.out.println("カードを山札の上に戻します");
		deck.put(one);

		System.out.println("もう1度引きます");
		Card onemore = deck.draw();
		System.out.println("引いたカードは" + onemore.getMark() + "の" + onemore.getNewNumber() + "です");

		assertEquals(one, onemore);

		System.out.println("──終了──\n");
	}

	@Test
	@DisplayName("カードインスタンスを作成しデッキに積み込むとそのカードが出現する")
	void test3() {
		System.out.println("カードインスタンスを作成しデッキに積み込むとそのカードが出現する");
		System.out.println("──開始──");
		System.out.println("カードを新しく作成します");
		Card newCard = new Card(13, "ダイヤ");

		System.out.println("作成したカードを山札に置いてシャッフルします。");
		deck.put(newCard);

		System.out.println("山札を全て見ます");
		for (Card c : deck.cards) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}

		System.out.println("──終了──\n");
	}

	@Test
	@DisplayName("大小の比較のメソッド テスト ジョーカーカード生成メソッドのテスト")
	void test4() {
		Card card1 = new Card(5, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "ハート");
		Card card4 = new Card(13, "クラブ");

		//card2がcard1より大きければ1を、小さければ-1を、同じであれば0を返すメソッドcompareToメソッドのテスト
		assertEquals(1, card2.compareTo(card1));
		assertEquals(-1, card1.compareTo(card2));
		assertEquals(0, card2.compareTo(card3));

		//マークが違えばそれも比較をするという照明
		assertEquals(1, card2.compareTo(card4));

		//ジョーカーカードを作るメソッドのテスト  ※ジョーカーカードが一番強い設定
		Card jorker = card.getJoker();
		assertEquals(1, jorker.compareTo(card2));
	}

	@Test
	@DisplayName("引いたカードがちゃんと山札からなくなっているかのテスト")
	void test5() {
		assertEquals(54, deck.cards.size());
		deck.draw();
		assertEquals(53, deck.cards.size()); //引いた後に1引いた数と合ったら成功
	}

	@Test
	@DisplayName("11以上の数値の際に、文字表現になっているかのテスト")
	void test6() {
		Card card1 = new Card(11, "ダイヤ");
		Card card2 = new Card(12, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(14, "ジョーカー");

		assertEquals("ジャック", card1.getNewNumber());
		assertEquals("クイーン", card2.getNewNumber());
		assertEquals("キング", card3.getNewNumber());
		assertEquals("ジョーカー", card4.getNewNumber());
	}
}
