package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import trump.Card.Mark;

class PlayerTest {
	//フィールドをprivateにしたので直接引っ張ていたところをgetterやsetterに変更

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

	//テスト
	@Test
	@DisplayName("ワンペアがあるかの判定メソッド")
	void test1() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(5, Mark.SPADE);
		Card card5 = new Card(11, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertTrue(player.isOnePair());

	}

	@Test
	@DisplayName("ワンペアがあるかの判定メソッド、Falseの場合")
	void test1_2() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(12, Mark.HEART);
		Card card3 = new Card(10, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(7, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertFalse(player.isOnePair());

	}

	@Test
	@DisplayName("ワンペア判定 ※他の役になっている場合")
	void test1_3() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(11, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertFalse(player.isOnePair());
	}

	@Test
	@DisplayName("ツーペアがあるかどうか")
	void test2() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertTrue(player.isTwoPair());
	}

	@Test
	@DisplayName("ツーペアがあるかどうかの判定falseの場合")
	void test2_2() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(11, Mark.CLUB);
		Card card4 = new Card(10, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertFalse(player.isTwoPair());
	}

	@Test
	@DisplayName("ツーペア判定のメソッド ※他の役になっている場合")
	void test2_3() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(13, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertFalse(player.isTwoPair());
	}

	@Test
	@DisplayName("スリーカード判定のメソッド")
	void test3_1() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(13, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertTrue(player.isThreeCard());
	}

	@Test
	@DisplayName("スリーカード判定のメソッド falseVer")
	void test3_2() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(12, Mark.SPADE);
		Card card5 = new Card(11, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		assertFalse(player.isThreeCard());
	}

	@Test
	@DisplayName("スリーカードの判定　メソッド")
	void test3_3() {

	}

	@Test
	@DisplayName("カードチェンジメソッド")
	void test4() {
		Card card = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		for (Card c : player.getList()) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}

		System.out.println("");
		Card card6 = new Card(10, Mark.CLUB);
		player.changeCard(5, card6);
		for (Card c : player.getList()) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}
	}
}
