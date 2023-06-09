package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import trump.Card.Mark;

class CardTest {

	Player player;
	Card card;
	Deck deck;
	List<Card> cardList;

	@BeforeEach
	public void setUp() {
		deck = new Deck();
		player = new Player();
		cardList = new ArrayList();
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのワンペア判定")
	void test1_1() {
		System.out.println("──Cardのstaticメソッドでのワンペア判定──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(10, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(5, Mark.SPADE);
		Card card5 = new Card(13, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isOnePair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}

		assertEquals(265, hand.getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのワンペア判定 false")
	void test1_2() {
		System.out.println("──Cardのstaticメソッドでのワンペア判定 false──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(10, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(5, Mark.SPADE);
		Card card5 = new Card(11, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isOnePair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}

		assertEquals(0, hand.getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのツーペア判定")
	void test2_1() {
		System.out.println("──Cardのstaticメソッドでのツーペア判定──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(6, Mark.SPADE);
		Card card5 = new Card(13, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}

		assertEquals(530, hand.getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのツーペア判定 false")
	void test2_2() {
		System.out.println("──Cardのstaticメソッドでのツーペア判定 false──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(8, Mark.HEART);
		Card card3 = new Card(11, Mark.CLUB);
		Card card4 = new Card(10, Mark.SPADE);
		Card card5 = new Card(5, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}
		assertEquals(0, hand.getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのツーペア判定 スリーカードの場合")
	void test2_3() {
		System.out.println("──Cardのstaticメソッドでのツーペア判定 スリーカードの場合──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(10, Mark.SPADE);
		Card card5 = new Card(5, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		assertEquals(0, hand.getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定")
	void test3_1() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定──");

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(10, Mark.SPADE);
		Card card5 = new Card(5, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		int power = card.isThreeCard(cardList);

		assertEquals(396, power);
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定 false")
	void test3_2() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定 false──");

		List<Card> trioCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(11, Mark.HEART);
		Card card3 = new Card(10, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(5, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		int power = card.isThreeCard(cardList);

		assertEquals(0, power);
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定 ツーペアの場合")
	void test3_3() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定 ツーペアの場合──");

		List<Card> trioCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(12, Mark.HEART);
		Card card3 = new Card(1, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(13, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		int power = card.isThreeCard(cardList);

		assertEquals(0, power);

	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定 フォーカードの場合")
	void test3_4() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定 フォーカードの場合──");

		List<Card> trioCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(2, Mark.SPADE);
		Card card5 = new Card(13, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		int power = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertEquals(396, power);

	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定 フルハウスの場合")
	void test3_5() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定 フルハウスの場合──");

		List<Card> trioCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(13, Mark.SPADE);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		int power = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertEquals(399, power);

	}

	@Test
	@DisplayName("レッドジョーカーとブラックジョーカーの強さのテスト")
	void test4_1() {
		Card card = Card.getBlackJoker();
		Card card2 = Card.getRedJoker();
		System.out.println(card.markAndNum() + "のパワー:" + card.getPower());
		System.out.println(card2.markAndNum() + "のパワー:" + card2.getPower());

		int compare = card.compareTo(card2);

		assertTrue(0 > compare);
	}

	@Test
	@DisplayName("レッドジョーカーとブラックジョーカーの強さのテスト false")
	void test4_2() {
		Card card = Card.getRedJoker();
		Card card2 = Card.getBlackJoker();

		int compare = card2.compareTo(card);

		assertFalse(0 < compare);
	}

	@Test
	@DisplayName("ジョーカーが入ったワンペアのテスト")
	void test5_1() {
		System.out.println("──ジョーカーが入ったワンペアのテスト──");

		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(11, Mark.HEART);
		Card card3 = new Card(10, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = Card.getBlackJoker();

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isOnePair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ジョーカーが入ったツーペアのテスト")
	void test5_2() {
		System.out.println("──ジョーカーが入ったツーペアのテスト──");

		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(10, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = Card.getBlackJoker();

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ジョーカーが入ったツーペアのテスト ジョーカー2枚")
	void test5_3() {
		System.out.println("──ジョーカーが入ったツーペアのテスト ジョーカー2枚──");

		List<Card> pairCard = new ArrayList();

		Card card = Card.getBlackJoker();
		Card card2 = Card.getRedJoker();
		Card card3 = new Card(13, Mark.DIAMOND);
		Card card4 = new Card(13, Mark.SPADE);
		Card card5 = new Card(10, Mark.CLUB);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ジョーカーが入ったツーペアのテスト ジョーカー入りのフルハウス")
	void test5_4() {
		System.out.println("──ジョーカーが入ったツーペアのテスト ジョーカー入りのフルハウス──");

		List<Card> pairCard = new ArrayList();

		Card card = Card.getBlackJoker();
		Card card2 = new Card(13, Mark.CLUB);
		Card card3 = new Card(13, Mark.DIAMOND);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(12, Mark.CLUB);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ジョーカーが入ったツーペアのテスト ジョーカー入りの4カード")
	void test5_5() {
		System.out.println("──ジョーカーが入ったツーペアのテスト ジョーカー入りの4カード──");

		List<Card> pairCard = new ArrayList();

		Card card = Card.getBlackJoker();
		Card card2 = new Card(13, Mark.CLUB);
		Card card3 = new Card(13, Mark.DIAMOND);
		Card card4 = new Card(13, Mark.SPADE);
		Card card5 = new Card(12, Mark.CLUB);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ジョーカーが入ったツーペアのテスト ジョーカー2枚")
	void test5_6() {
		System.out.println("──ジョーカーが入ったツーペアのテスト ジョーカー2枚──");

		List<Card> pairCard = new ArrayList();

		Card card = Card.getBlackJoker();
		Card card2 = Card.getRedJoker();
		Card card3 = new Card(13, Mark.DIAMOND);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(10, Mark.CLUB);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		Hand hand = card.isTwoPair(cardList);

		System.out.println(hand.getPower());

		assertTrue(0 < hand.getPower());
	}

	@Test
	@DisplayName("ソート機能 確認用")
	void test6_1() {
		System.out.println("──ソート機能 確認用──");
		Card card = new Card(8, Mark.CLUB);
		Card card2 = new Card(4, Mark.HEART);
		Card card3 = new Card(10, Mark.DIAMOND);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(10, Mark.CLUB);
		Card card6 = new Card(11, Mark.DIAMOND);
		Card card7 = new Card(1, Mark.SPADE);
		Card card8 = new Card(2, Mark.CLUB);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);
		cardList.add(card6);
		cardList.add(card7);
		cardList.add(card8);
		for (Card c : cardList) {
			System.out.println(c.markAndNum());
		}
		List<Card> sortList = Card.sortList(cardList);
		System.out.println("");
		for (Card c : sortList) {
			System.out.println(c.markAndNum());
		}

	}
}
