package babanuki;

import java.util.ArrayList;

public class Hand {
	//手札にあるカードを保持するためのリスト
	private ArrayList hand_ = new ArrayList();
	
	//カードを加える
	public void addCard(Card card) {
		//カードをリストの最後に追加する
		hand_.add(card);
	}
	
	//カードを引く
	public Card pickCard() {
		Card pickCard = (Card) hand_.remove(0);
		return pickCard;
	}
	
	//シャッフルする
	public void shuffle() {
		//手札の枚数を取得
		int number = hand_.size();
		//カードを抜きだす位置
		int pos;
		//カードをランダムに抜き取って最後に加える動作を繰り返す
		for(int count = 0; count < number * 2; count++) {
			//ランダムな位置からカードを一枚抜き取る
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card) hand_.remove(pos);
			//抜き取ったカードを最後に加える
			hand_.add(pickedCard);
		}
	}
	
	//枚数を数える
	public int getNumberofCards() {
		return hand_.size();
	}
	
	//同じ数のカードを探す。同じ数がない場合はnullを返す
	public Card[] findSameNumberCard() {
		int numberOfCards = hand_.size();
		Card[] sameCards = null;
		
		//手札にカードが一枚もない場合は何もしない
		if(numberOfCards > 0) {
			//最後に追加されたカードを取得する
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand_.get(lastIndex);
			
			//最後に追加されたカードの数字を取得する
			int lastAddedCardNum = lastAddedCard.getNumber();
			for(int index = 0; index < lastIndex; index++) {
				Card card = (Card) hand_.get(index);
				if(card.getNumber() == lastAddedCardNum) {
					//最後に追加されたカードと同じカードが見つかった場合
					//見つかった組み合わせをsameCardsに格納し、ループをぬける
					sameCards = new Card[2];
					sameCards[0] = (Card) hand_.remove(lastIndex);
					sameCards[1] = (Card) hand_.remove(index);
					break;
				}
				//同じ数の組み合わせが見つからなかった場合
				//sameCardsはnullのままとなる
			}
		}
		return sameCards;
	}
	//手札にあるカードを文字列として表現する
	public String toString() {
		StringBuffer string = new StringBuffer();
		int size = hand_.size();
		if(size > 0) {
			for(int index = 0; index < size; index++) {
				Card card = (Card) hand_.get(index);
				string.append(card);
				string.append(" ");
			}
		}
		return string.toString();
	}
}
