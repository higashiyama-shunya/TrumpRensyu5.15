package trump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	//フィールドをprivateにしたので直接引っ張ていたところをgetterやsetterに変更

	Player player;
	Card card;
	Deck deck;
	List<Card> list;

	@BeforeEach
	public void setUp() {
		deck = new Deck();
		player = new Player();
		list=new ArrayList();
	}
	//テスト
	@Test
	@DisplayName("ワンペアがあるかの判定メソッド")
	void test1() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(5, "スペード");
		Card card5 = new Card(11, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		assertTrue(player.isOnePair());

	}
	
	@Test
	@DisplayName("ワンペアがあるかの判定メソッド、Falseの場合")
	void test1_2() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(12, "ハート");
		Card card3 = new Card(10, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(7, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		assertFalse(player.isOnePair());

	}
	@Test
	@DisplayName("ワンペア判定 ※他の役になっている場合")
	void test1_3() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(11,"スペード");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		assertFalse(player.isOnePair());
	}

	@Test
	@DisplayName("ツーペアがあるかどうか")
	void test2() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);

		assertTrue(player.isTwoPair());
	}
	
	@Test
	@DisplayName("ツーペアがあるかどうかの判定falseの場合")
	void test2_2() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		assertFalse(player.isTwoPair());
	}
	
	@Test
	@DisplayName("ツーペア判定のメソッド ※他の役になっている場合")
	void test2_3() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(13, "クラブ");
		Card card4 = new Card(13, "スペード");
		Card card5 = new Card(12, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		assertFalse(player.isTwoPair());
	}

	@Test
	@DisplayName("カードチェンジメソッド")
	void test3() {
		Card card = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		
		player.setList(list);
		
		for (Card c : player.getList()) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}

		System.out.println("");
		Card card6 = new Card(10, "クラブ");
		player.changeCard(5, card6);
		for (Card c : player.getList()) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}
	}
}
