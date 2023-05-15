package trump;

public class Card {
	//フィールド
	private int Number;
	private String Mark;
	private int Priority;

	//コンストラクタ
	public Card(int number, String mark) {
		this.Number = number;
		this.Mark = mark;
		if (mark.equals("ジョーカー")) {
			this.Priority = 5;
		} else if (mark.equals("スペード")) {
			this.Priority = 4;
		} else if (mark.equals("ハート")) {
			this.Priority = 3;
		} else if (mark.equals("ダイヤ")) {
			this.Priority = 2;
		} else if (mark.equals("クラブ")) {
			this.Priority = 1;
		}

	}

	//メソッド
	//NumberとMarkを取得するメソッド
	public String getNumber() {
		return Integer.toString(this.Number);
	}

	public String getMark() {
		return this.Mark;
	}

	//大小を比較するメソッド
	public int compareTo(Card anotherCard) {
		if (Integer.compare(this.Number, anotherCard.getPower()) == 0) {
			return Integer.compare(this.Priority, anotherCard.Priority);
		}
		return Integer.compare(this.Number, anotherCard.getPower());
	}

	//数値を代わりにintとして渡すメソッド
	public int getPower() {
		return this.Number;
	}

	//11以上の数値を文字表現にして返すメソッド
	public String getNewNumber() {
		if (this.Number == 11) {
			return "ジャック";
		} else if (this.Number == 12) {
			return "クイーン";
		} else if (this.Number == 13) {
			return "キング";
		} else if (this.Number >= 14) {
			return "ジョーカー";
		} else {
			return Integer.toString(this.Number);
		} //このメソッドを新しく作るのではなく、本来のgetNumberに追加した書いたほうがメソッドが少なくなって分かりやすい。
	}

	//ジョーカーを生成するメソッド
	public static Card getJoker() {
		Card card = new Card(99, "ジョーカー");
		return card;

	}

}
