package trump;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import trump.Card.Mark;

public class Main4 {

	public static void main(String[] args) {
		//カードを好きな枚数引いてその中で一番数字が大きいカードを表示
		Deck deck = new Deck();
		maxCard(deck);
		System.out.println("デッキをシャッフルします。");
		deck.shuffle();
		maxCard(deck);

		System.out.println("次にポーカーです。");
		porker(deck);

	}

	//カードのマークと数字を表示するメソッド
	public static void showCard(Card card) {
		System.out.println(card.markAndNum() + "です。");
	}

	//入力した分カードを引いて最大の値のカードを表示するメソッド
	public static void maxCard(Deck deck) {
		Scanner sc = new Scanner(System.in);
		System.out.println("引くカードの枚数を選択してください。");
		int cardNum = sc.nextInt();
		List<Card> cardList = new ArrayList();
		System.out.println("引いたカードは");
		for (int i = 0; i < cardNum; i++) {
			Card card = deck.draw();
			cardList.add(card);
			System.out.print(card.markAndNum() + ",");
		}
		System.out.println("です。");
		Card maxCard = new Card(0, Mark.CLUB);

		for (Card card : cardList) {
			int compare = card.compareTo(maxCard);
			if (compare > 0) {
				maxCard = card;
			}
		}
		System.out.println("一番数字が大きいカードは");
		showCard(maxCard);
	}

	//カードを5枚引いて役ができているか確認して、手札と役を表示するメソッド
	public static void porker(Deck deck) {
		Player player = new Player(); //手札を引く役としてプレイヤーをインスタンス化
		List<Card> hand = player.getList(); //手札を受け取る用のリスト
		List<Card> pairCard = new ArrayList(); //役があった時のカードを受け取るリスト

		System.out.println("カードを5枚引きます");

		for (int i = 0; i < 5; i++) {
			Card card = deck.draw();
			hand.add(card);
		}

		String role = null; //役の名前を受け取る変数

		pairCard = Card.isThreeCard(hand);
		if (pairCard != null) {
			role = "スリーカード";
		} else {
			pairCard = Card.isTwoPair(hand);
			if (pairCard != null) {
				role = "ツーペア";
			} else {
				pairCard = Card.isOnePair(hand);
				if (pairCard != null) {
					role = "ワンペア";
				}
			}
		}
		System.out.println("引いたカードは");
		for (Card c : hand) {
			System.out.print(c.markAndNum() + ",");
		}
		System.out.println("です。");
		System.out.print("役は");
		if (role != null) {
			System.out.print(role + "です。\n");
		} else {
			System.out.print("無役です。\n");
		}

	}
}
