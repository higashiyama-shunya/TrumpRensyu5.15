package trump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player player;
	Card card;
	Deck deck;

	@BeforeEach
	public void setUp() {
		deck = new Deck();
		player = new Player();
	}

	@Test
	@DisplayName("ワンペアがあるかの判定メソッド")
	void test() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(5, "スペード");
		Card card5 = new Card(11, "ハート");

		player.list.add(card);
		player.list.add(card2);
		player.list.add(card3);
		player.list.add(card4);
		player.list.add(card5);

		assertTrue(player.isOnePair());

	}

	@Test
	@DisplayName("ツーペアがあるかどうか")
	void test2() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		player.list.add(card);
		player.list.add(card2);
		player.list.add(card3);
		player.list.add(card4);
		player.list.add(card5);

		assertTrue(player.isTwoPair());
	}

	@Test
	@DisplayName("カードチェンジメソッド")
	void test3() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		player.list.add(card);
		player.list.add(card2);
		player.list.add(card3);
		player.list.add(card4);
		player.list.add(card5);
		for (Card c : player.list) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}

		System.out.println("");
		Card card6 = new Card(10, "クラブ");
		player.changeCard(5, card6);
		for (Card c : player.list) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}
	}
}
