package Main;

import java.util.ArrayList;
import java.util.List;

import Main.card;

public class deck {
	
	List<card> deck = new ArrayList<card>(); 
	

	//This constructor populates the deck with 52 objects (cards)
	public deck() {
		
		for (Suit suit : Suit.values())
		{
			for(Face face : Face.values())
			{
				card card = new card(suit, face, face.ordinal() + 1);
				deck.add(card);
			}
		}
		
	}
	
	//Method to get a specific card from the deck
	public card getCard(int i)
	{
		return deck.get(i);
	}
	
	//This method shuffles the deck by swapping two cards at a time ten thousand times
	public void shuffle() {
		
		
		for(int i = 0; i < 10000; i++)
		{
		    int random_1 = (int)Math.floor(Math.random() * (51 + 1));
		    int random_2 = (int)Math.floor(Math.random() * (51 + 1));
		    
		    card cardOne = deck.get(random_1);
		    card cardTwo = deck.get(random_2);
		    
		    deck.set(random_1, cardTwo);
		    deck.set(random_2, cardOne);
		}
		
	}



}