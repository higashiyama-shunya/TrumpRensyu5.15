package trump;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaraniChallenge {

	public static void main(String[] args) {
		//フィールドをprivateにしたので直接引っ張ていたところをgetterやsetterに変更
		Deck deck = new Deck();
		Player player = new Player();
		List<Card> list=new ArrayList();
		deck.shuffle();

		System.out.println("カードを5枚引きます。");

		for (int i = 0; i < 5; i++) {
			Card card = deck.draw();
			list.add(card);
		}
		player.setList(list);

		System.out.println("あなたが引いたカードは");
		for (int i = 0; i < player.getList().size(); i++) {
			Card ca;
			ca = player.getList().get(i);
			System.out.println((i + 1) + "番:" + ca.getMark() + "の" + ca.getNewNumber());
		}
		System.out.println("以上の5枚です。");

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("カードを交換しますか？YESならy、NOならnと打ってください");
			String yesno = sc.nextLine();
			if (yesno.equals("y")) {
				System.out.println("交換したいカードの番号を入力してください");
				try {
					int num = sc.nextInt();
					Card card = deck.draw();
					if (card != null) {
						Card card2 = player.getList().get(num-1);
						player.changeCard(num, card);
						deck.put(card2);
						deck.shuffle();

						System.out.println("交換したカードは" + card.getMark() + "の" + card.getNewNumber() + "です。");

						System.out.println("────現在の手札────");
						for (int i = 0; i < player.getList().size(); i++) {
							Card c;
							c = player.getList().get(i);
							System.out.println((i + 1) + "番:" + c.getMark() + "の" + c.getNewNumber());
						}
						System.out.println("─────────────");
						}
				}catch(Exception e) {
					System.out.println("無効な値です。もう1度やり直してください。");
					continue;
				}

			} else if (yesno.equals("n")) {
				break;
			} else {
				System.out.println("無効な値です。もう1度打ちなおしてください");
			}
		}
		System.out.println("あなたが持っているカードは");
		for (Card c : player.getList()) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}
		System.out.println("です。");
	}

}
