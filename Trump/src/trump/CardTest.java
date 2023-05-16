package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(5, "スペード");
		Card card5 = new Card(11, "ハート");

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

		assertEquals(pairCard.get(0).getPower(), pairCard.get(1).getPower());
	}

	@Test
	@DisplayName("Cardのstaticメソッドでのワンペア判定 false")
	void test1_2() {
		System.out.println("──Cardのstaticメソッドでのワンペア判定 false──");
		List<Card> pairCard = new ArrayList();

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(10, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(5, "スペード");
		Card card5 = new Card(11, "ハート");

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

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(6, "スペード");
		Card card5 = new Card(13, "スペード");

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

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(8, "ハート");
		Card card3 = new Card(11, "クラブ");
		Card card4 = new Card(10, "スペード");
		Card card5 = new Card(5, "スペード");

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

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(10, "スペード");
		Card card5 = new Card(5, "スペード");

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

		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(10, "スペード");
		Card card5 = new Card(5, "スペード");

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
	}
}
