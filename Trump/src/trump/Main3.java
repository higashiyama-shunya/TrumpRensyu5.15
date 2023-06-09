package trump;

import java.util.ArrayList;
import java.util.List;

import trump.Card.Mark;

public class Main3 {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player = new Player();
		List<Card> cardList = new ArrayList();

		Card card1 = new Card(13, Mark.DIAMOND);
		Card card2 = new Card(13, Mark.HEART);
		Card card3 = new Card(12, Mark.CLUB);
		Card card4 = new Card(11, Mark.SPADE);
		Card card5 = new Card(12, Mark.HEART);

		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		player.isTwoPair();
	}

}
