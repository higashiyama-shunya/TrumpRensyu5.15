package trump;

import java.util.Scanner;

public class SaraniChallenge {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player = new Player();
		deck.shuffle();

		System.out.println("カードを5枚引きます。");

		for (int i = 0; i < 5; i++) {
			Card card = deck.draw();
			player.list.add(card);
		}

		System.out.println("あなたが引いたカードは");
		for (int i = 0; i < player.list.size(); i++) {
			Card ca;
			ca = player.list.get(i);
			System.out.println((i + 1) + "番:" + ca.getMark() + "の" + ca.getNewNumber());
		}
		System.out.println("以上の5枚です。");

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("カードを交換しますか？YESならy、NOならnと打ってください");
			String yesno = sc.nextLine();
			if (yesno.equals("y")) {
				System.out.println("交換したいカードの番号を入力してください");
				int num = sc.nextInt();
				Card card = deck.draw();
				if (card != null) {
					Card card2 = player.list.get(num - 1);
					player.changeCard(num, card);
					deck.put(card2);
					deck.shuffle();

					System.out.println("交換したカードは" + card.getMark() + "の" + card.getNewNumber() + "です。");

					System.out.println("────現在の手札────");
					for (int i = 0; i < player.list.size(); i++) {
						Card c;
						c = player.list.get(i);
						System.out.println((i + 1) + "番:" + c.getMark() + "の" + c.getNewNumber());
					}
					System.out.println("─────────────");
				} else {

				}
			} else if (yesno.equals("n")) {
				break;
			} else {
				System.out.println("有効な値ではありません。もう1度打ちなおしてください");
			}
		}
		System.out.println("あなたが持っているカードは");
		for (Card c : player.list) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}
		System.out.println("です。");
	}

}
