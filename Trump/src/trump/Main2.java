package trump;

public class Main2 {

	public static void main(String[] args) {
		//Deckのインスタンス化
		Deck deck = new Deck();

		//一番上のカードを1枚引いて表示する
		Card one = deck.draw();
		System.out.println("1枚目:" + one.markAndNum());
		System.out.println("");

		//シャッフルする
		System.out.println("──シャッフル──");
		deck.shuffle();
		System.out.println("");

		System.out.println("シャッフルした後のカードの並び");
		for (Card card : deck.getCards()) {
			System.out.println(card.markAndNum());
		}

		//1番上のカードを1枚引いて表示する
		System.out.println("");
		System.out.println("シャッフル後のカードを2枚引く");
		Card two = deck.draw();
		System.out.println("2枚目:" + two.markAndNum());

		//1番の上のカードを1枚引いて表示する
		Card three = deck.draw();
		System.out.println("3枚目:" + three.markAndNum());

		System.out.println("");

		//引いたカードを山札の1番上に戻す。
		deck.put(three);
		System.out.println("──カードを戻す──");
		System.out.println("戻したカード:" + three.markAndNum() + "\n");

		for (Card card : deck.getCards()) {
			System.out.println(card.markAndNum());
		}

		for (int i = 0; i < 100; i++) {
			Card las = deck.draw();
			if (las != null) {
				System.out.println(las.markAndNum());
			} else {
				System.out.println("カードがもうありません");
				break;
			}
		}
	}

}
