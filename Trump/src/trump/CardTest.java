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

		Card card = new Card(7, Mark.DIAMOND);
		Card card2 = new Card(11, Mark.HEART);
		Card card3 = new Card(2, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(1, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		pairCard = card.isOnePair(cardList);

		for (Card c : pairCard) {
			System.out.println(c.markAndNum());
		}

		assertEquals(pairCard.get(0).getPower(), pairCard.get(1).getPower());
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

		pairCard = card.isOnePair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}

		assertEquals(0, pairCard.size());
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

		pairCard = card.isTwoPair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}

		assertEquals(4, pairCard.size());
		assertEquals(pairCard.get(0).getPower(), pairCard.get(1).getPower());
		assertEquals(pairCard.get(2).getPower(), pairCard.get(3).getPower());
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

		pairCard = card.isTwoPair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}
		assertTrue(3 > pairCard.size());
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

		pairCard = card.isTwoPair(cardList);

		for (Card c : pairCard) {
			c.markAndNum();
		}
		assertTrue(3 > pairCard.size());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのスリーカード判定")
	void test3_1() {
		System.out.println("──Cardのstaticメソッドでのスリーカード判定──");
		List<Card> trioCard = new ArrayList();

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

		trioCard = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertEquals(3, trioCard.size());
		assertEquals(trioCard.get(0).getPower(), trioCard.get(1).getPower());
		assertEquals(trioCard.get(1).getPower(), trioCard.get(2).getPower());
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

		trioCard = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}
		assertTrue(3 > trioCard.size());
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

		trioCard = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertTrue(3 > trioCard.size());

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

		trioCard = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertEquals(3, trioCard.size());
		assertEquals(trioCard.get(0).getPower(), trioCard.get(1).getPower());
		assertEquals(trioCard.get(1).getPower(), trioCard.get(2).getPower());

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

		trioCard = card.isThreeCard(cardList);

		for (Card c : trioCard) {
			c.markAndNum();
		}

		assertEquals(3, trioCard.size());
		assertEquals(trioCard.get(0).getPower(), trioCard.get(1).getPower());
		assertEquals(trioCard.get(1).getPower(), trioCard.get(2).getPower());

	}
}
