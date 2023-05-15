package trump;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player = new Player();
		List<Card> cardList = new ArrayList();

		Card card1 = new Card(13, "ダイヤ");
		Card card2 = new Card(13, "ハート");
		Card card3 = new Card(12, "クラブ");
		Card card4 = new Card(11, "スペード");
		Card card5 = new Card(12, "ハート");

		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);

		player.setList(cardList);

		player.isTwoPair();
	}

}
