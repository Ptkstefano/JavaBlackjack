package Main;

public enum Suit {

	SPADES("spades", "♠"),
	HEARTS("hearts", "♥"),
	DIAMONDS("diamonds","♦"),
	CLUBS("clubs","♣");

	private String suitName;
	private String suitSymbol;
	
	Suit(String suitName, String suitSymbol) {
		this.suitName = suitName;
		this.suitSymbol = suitSymbol;
	}

	public String getSuitName() {
		return suitName;
	}

	public String getSuitSymbol() {
		return suitSymbol;
	}
	
}
