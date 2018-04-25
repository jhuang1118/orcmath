package symposium;

import guiTeacher.components.Graphic;

public class Card {

	private int rank;
	private int suit;
	private Graphic cardImg;
	private int value;

	public Card(int rank, int suit, String cardImg, int value) {
		this.rank = rank;
		this.suit = suit;
		this.cardImg = new Graphic(0,0,100,100,"cardImages/" + rank + suit + ".png");
		this.value = value;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public Graphic getCardImg() {
		return cardImg;
	}

	public void setCardImg(Graphic cardImg) {
		this.cardImg = cardImg;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
