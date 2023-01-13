package Main;

import java.util.Scanner;

import Main.card;

public class Main {

    public static void main(String[] args) {
    	
    	//Generates a deck with 52 cards
    	deck deck = new deck();
    	Hand pHand = new Hand();
    	Hand dHand = new Hand();
    	
    	deck.shuffle();
    	
    	int cardCount = 0;
    	int playerCard = 0;  
    	boolean start = true;
    	boolean stand = false;
    	boolean bust = false;
    	
    	boolean playerNatural = false;
    	boolean dealerNatural = false;
    	boolean natural = false;
    	
    	int playerScore = 0;
    	int dealerScore = 0;
    	
		Scanner scanner = new Scanner(System.in);
    	String input = "";
    
    	
    	while(!input.equals("q"))
    	{
    		
    		if(start)
    		{
    			
    			pHand.draw(deck, cardCount);
    			cardCount++;
    			pHand.draw(deck, cardCount);
    			cardCount++;
    			dHand.draw(deck, cardCount);
    			cardCount++;
    			dHand.draw(deck, cardCount);
    			cardCount++;
    			
    			if(pHand.calculateSum() == 21)
    			{
    				System.out.println("Player's blackjack!");
    				playerNatural = true;
    			}
    			if(dHand.calculateSum() == 21)
    			{
    				System.out.println("Dealer's blackjack!");
    				dealerNatural = true;
    			}
    			if(playerNatural || dealerNatural)
    			{
    				stand = true;
    				natural = true;
    			}
    			
    			start=false;
    		}
    		
    		
    		
    		//Loops here and continues while player can take actions		
    		if(!bust && !stand && !natural)
    		{
    			System.out.println("Your hand:");
        		pHand.showHand();
        		System.out.println("Dealer's hand:");
        		dHand.showHidden();
        		System.out.println("h - hit | s - stand | q - quit");
        		input = scanner.next();
        		
        		switch(input) {
        		case("h"):
        			pHand.draw(deck, cardCount);
        			cardCount++;
        			break;
        		case("s"):
        			stand = true;
        			break;
        		}
        		
        		//Detects if player hand is busted
        		if(pHand.calculateSum() > 21)
        		{
            		pHand.showHand();
        			System.out.println("Bust");
        			bust = true;
        		}
        		//Detects if player has reached 21
        		else if(pHand.calculateSum() == 21)
        		{
        			System.out.println("21!");
        			stand = true;
        		}
    		}

    		
    		//Dealer plays once player busted or has chosen to stand
    		if(stand || bust)
    		{	
    			//Dealer draws until he has at least a sum of 17
    			while(dHand.calculateSum() < 17)
    			{
    				dHand.draw(deck, cardCount);
    				cardCount++;
    			}
    			
    			System.out.println("Dealer's hand: ");
    			dHand.showHand();
    			
    		}

			//Scoring
    		
    		if(stand || natural || bust)
    		{
	    		
	    		if(natural)
	    		{
	    			if(playerNatural && !dealerNatural)
	    			{
	    				System.out.println("You win");
	    				playerScore++;
	    			}
	    			else if(!playerNatural && dealerNatural)
	    			{
	    				System.out.println("Dealer wins");
	    				dealerScore++;
	    			}
	    			else
	    			{
	    				System.out.println("Blackjack Tie!");
	    			}				
	
	    		}
	    		
	    		else if(bust)
				{
					System.out.println("Dealer wins");
					dealerScore++;
				}
				else if(pHand.calculateSum() < dHand.calculateSum())
				{
					if(dHand.calculateSum() > 21)
					{
		    			System.out.println("Dealer has busted");
	    				System.out.println("Player wins");
	    				playerScore++;
					}
					else
					{
	    				System.out.println("Dealer wins");
	    				dealerScore++;
					}
				}
				else if(pHand.calculateSum() > dHand.calculateSum() && !natural)
				{
					System.out.println("Player wins");
					playerScore++;
				}
				else
				{
					System.out.println("Tie");
				}
				
				System.out.println("Player score: " + playerScore + " | Dealer score: " + dealerScore);
	    		System.out.println("r - restart | q - quit");
	    		input = scanner.next();
				
	    		switch(input) {
	    		//Restart the game's variables starting a new one
	    		case("r"):
	    			deck.shuffle();
	    			cardCount = 0;
	    			playerCard = 0;
	    			start=true;
	    			bust=false;
	    			stand=false;
	    			natural = false;
	    			playerNatural = false;
	    			dealerNatural = false;
	    			pHand.clear();
	    			dHand.clear();
	    			input = "";
	    			break;
	    		}
    			
    		}
    		
    	}
    		
    	System.out.println("Quitting blackjack");
    	
	}


    
}