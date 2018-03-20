package symposium;

import guiTeacher.components.Graphic;

public class Card {

	private int rank;
	private int suit;
	private Graphic cardImg;

	public Card(int rank, int suit, String cardImg) {
		this.rank = rank;
		this.suit = suit;
		this.cardImg = new Graphic(0,0,100,100,"cardImages/" + rank + suit + ".png");
	}
	
}
