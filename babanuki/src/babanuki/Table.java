package babanuki;

import java.util.ArrayList;

public class Table {
	//捨てられたカードを保持しておくためのリスト
	private ArrayList disposedCards_ = new ArrayList();
	
	//カードを捨てる
	public void disposeCard(Card card[]) {
		for(int index = 0; index < card.length; index++) {
			System.out.println(card[index] + " ");
		}
		System.out.println("を捨てました");
		
		//捨てられたカードはリストに追加して保持しておく
		disposedCards_.add(card);
	}
}
