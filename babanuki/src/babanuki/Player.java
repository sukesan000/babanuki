package babanuki;

import sun.tools.tree.ThisExpression;

public class Player {
	private Master masetr_;
	private Table table_;
	private Hand myHand_;
	private String name_;
	
	//コンストラクタ
	public Player(String name, Master master, Table table) {
		this.name_ = name;
		this.masetr_ = master;
		this.table_ = table;
	}
	
	//順番を指名する
	//nextPlayer 次のプレイヤー
	public void play(Player nextPlayer) {
		//次のプレイヤーに手札を出してもらう
		Hand nextHand = nextPlayer.showHand();
		//相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard();
		//引いた結果を表示
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		//引いたカードを自分の手札に加え、同じカードがあったら捨てる
		dealCard(pickedCard);
		//手札がゼロになったかどうか調べる
		if(myHand_.getNumberofCards() == 0) {
			//進行役に上がりを宣言する
			master_.declearWin(this);
		}else {
			//現在の手札を表示する
			System.out.println(this + ":残りの手札は"　+ myHand_ + "です");
		}
	}
	//手札を見せる
	public Hand showHand() {
		//もしこの時点で手札が残り一枚ならば上がりとなるので宣言する
		if(myHand_.getNumberofCards() == 1) {
			master_.deckareWin(this);
		}
		//見せる前にシャッフルする
		myHand_.shuffle();
		
		return myHand_; 
	}
	//カードを受け取る
	//card 受け取ったカード
	public void receiveCard(Card card) {
		//カードを自分の手札に加える
		myHand_.addCard(card);
		//今加えたカードと同じカードを探す
		Card[] sameCards = myHand_.findSameNumberCard();
		//同じカードの組み合わせが存在した場合
		if(sameCards != null) {
			//テーブルへカードを捨てる
			System.out.print(this + ":");
			table_.disposeCard(sameCards);
		}
	}
	//プレイヤーの名前を返す
	public String toString() {
		return name_;
	}
}
