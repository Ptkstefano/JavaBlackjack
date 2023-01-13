package Main;

public class card {

	private Suit suit;
	private Face face;
	private int value;
	
	//Constructor
	public card(Suit suit, Face face, int value) {
		this.suit = suit;
		this.face = face;
		this.value = face.getValue();
	}

	
	public String getCardName() {
		String cardName = this.getFace() + " of " + this.getSuit().getSuitName();
		return cardName;
	}
	
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Face getFace() {
		return face;
	}
	public void setFace(Face face) {
		this.face = face;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	
}
