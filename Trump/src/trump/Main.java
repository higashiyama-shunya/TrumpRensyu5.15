package trump;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deck deck;
		List<Card> list;

		deck = new Deck();
		deck.shuffle();

		System.out.println("カードを5枚引いて最も強いカードを表示");
		System.out.println("──開始──");
		list = new ArrayList();
		List<Card> maxList = new ArrayList();

		System.out.println("カードを5枚引きます");

		for (int i = 0; i < 5; i++) {
			Card draw = deck.draw();
			list.add(draw);

		}

		Card max = new Card(0, "");

		for (Card c : list) {
			if (c.compareTo(max) == 1) {
				max = c;
			}
		}

		System.out.println("引いた5枚のカードは...");
		for (Card c : list) {
			String mark = c.getMark();
			String Number = c.getNumber();
			if (Number.equals("11")) {
				Number = "ジャック";
			} else if (Number.equals("12")) {
				Number = "クイーン";
			} else if (Number.equals("13")) {
				Number = "キング";
			} else if (Number.equals("14")) {
				Number = "ジョーカー";
			}
			System.out.print(mark + "の" + Number + ",");
		}
		System.out.println("の5枚で、その中で最も強いカードは");
		System.out.println(max.getMark() + "の" + max.getNewNumber() + "です");
		System.out.println("──終了──\n");

		System.out.println("デッキにカードを戻して引くと同じカードが出現する。");
		System.out.println("──開始──");
		System.out.println("カードを引きます");
		Card one = deck.draw();
		System.out.println("引いたカードは" + one.getMark() + "の" + one.getNewNumber() + "です");

		System.out.println("カードを山札の上に戻します");
		deck.put(one);

		System.out.println("もう1度引きます");
		Card onemore = deck.draw();
		System.out.println("引いたカードは" + onemore.getMark() + "の" + onemore.getNewNumber() + "です");

		System.out.println("──終了──\n");

		System.out.println("カードインスタンスを作成しデッキに積み込むとそのカードが出現する");
		System.out.println("──開始──");
		System.out.println("カードを新しく作成します");
		System.out.println("好きなカードのマークと数字を入力してください");
		Scanner sc = new Scanner(System.in);
		System.out.println("マークをカタカナで入力");
		String m = sc.next();
		System.out.println("数字を1~13までで入力");
		int n = sc.nextInt();
		Card newCard = new Card(n, m);

		System.out.println("作成したカードを山札に置いてシャッフルします。");
		deck.put(newCard);
		deck.shuffle();

		System.out.println("山札を全て見ます");
		for (Card c : deck.cards) {
			System.out.println(c.getMark() + "の" + c.getNewNumber());
		}

		System.out.println("──終了──\n");

	}

}
