package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import trump.Card.Mark;

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

		System.out.println("カードを2枚引きます");
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(10, Mark.DIAMOND);
		System.out.println(card.markAndNum() + "と" + card2.markAndNum());

		System.out.println("2枚のうち、強いカードは");

		int compare = card.compareTo(card2);

		if (compare > 0) {
			System.out.println(card.markAndNum() + "の方が強い");
		} else if (compare < 0) {
			System.out.println(card2.markAndNum() + "の方が強い");
		} else {
			System.out.println("引き分けです");
		}

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
		System.out.println("引いたカードは" + one.markAndNum() + "です");

		System.out.println("カードを山札の上に戻します");
		deck.put(one);

		System.out.println("もう1度引きます");
		Card onemore = deck.draw();
		System.out.println("引いたカードは" + onemore.markAndNum() + "です");

		assertEquals(one, onemore);

		System.out.println("──終了──\n");
	}

	@Test
	@DisplayName("カードインスタンスを作成しデッキに積み込むとそのカードが出現する")
	void test3() {
		System.out.println("カードインスタンスを作成しデッキに積み込むとそのカードが出現する");
		System.out.println("──開始──");
		System.out.println("カードを新しく作成します");
		Card newCard = new Card(13, Mark.HEART);

		System.out.println("作成したカードを山札に置いてシャッフルします。");
		deck.put(newCard);

		System.out.println("山札を全て見ます");
		for (Card c : deck.getCards()) {
			System.out.println(c.markAndNum());
		}

		System.out.println("──終了──\n");
	}

	@Test
	@DisplayName("大小の比較のメソッド テスト ジョーカーカード生成メソッドのテスト")
	void test4() {
		Card card1 = new Card(5, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.HEART);
		Card card4 = new Card(13, Mark.CLUB);

		//card2がcard1より大きければ1を、小さければ-1を、同じであれば0を返すメソッドcompareToメソッドのテスト
		//comparetoメソッドを-1,0,1じゃなくパワーの差を戻り値にしたためテストも0より上か、0未満かで判定するように修正
		assertTrue(0 < card2.compareTo(card1));
		assertTrue(0 > card1.compareTo(card2));
		assertEquals(0, card2.compareTo(card3));

		//マークが違えばそれも比較をするという照明
		assertTrue(0 < card2.compareTo(card4));

		//ジョーカーカードを作るメソッドのテスト  ※ジョーカーカードが一番強い設定
		Card jorker = card.getRedJoker();
		assertTrue(0 < jorker.compareTo(card2));
	}

	@Test
	@DisplayName("引いたカードがちゃんと山札からなくなっているかのテスト")
	void test5() {
		assertEquals(54, deck.getCards().size());
		deck.draw();
		assertEquals(53, deck.getCards().size()); //引いた後に1引いた数と合ったら成功
	}

	@Test
	@DisplayName("11以上の数値の際に、文字表現になっているかのテスト")
	void test6() {
		Card card1 = new Card(11, Mark.DIAMOND);
		Card card2 = new Card(12, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = Card.getRedJoker();

		assertEquals("ジャック", card1.getNewNumber());
		assertEquals("クイーン", card2.getNewNumber());
		assertEquals("キング", card3.getNewNumber());
		System.out.println(card4.markAndNum());
	}
}
