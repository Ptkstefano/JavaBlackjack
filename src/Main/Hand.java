package Main;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<card> hand = new ArrayList<card>();

	public void showHand() {
		String handList = "";
		for(card card : hand)
		{
			System.out.print(card.getCardName() + ", ");
		}
		System.out.println("");
		return;
		
	}

	public void draw(deck deck, int i) {
		hand.add(deck.deck.get(i));
	}

	public int calculateSum() {
		int sum = 0;
		int aceCount = 0;
		for(card card : hand)
		{
			if (card.getValue() == 0)
			{
				aceCount++;
				sum += 11;
			}
			
			sum += card.getValue();
		}
		
		while(sum > 21 && aceCount > 0)
		{
			sum -= 10;
			aceCount--;
		}
		
		return sum;
		
	}

	public void clear() {
		hand.clear();
	}

	public void showHidden() {
		//Dealer only reveals his second starting card if first one is either ten or ace
		System.out.print(hand.get(0).getCardName() + ", ");
		
		if (hand.get(0).getValue() == 0 || hand.get(0).getValue() == 10)
		{
			System.out.print(hand.get(1).getCardName() + ", ");
		}
		else
		{
			System.out.print("*hidden*");
		}
		
		System.out.println("");
		return;
		
	} 
	
	
}
