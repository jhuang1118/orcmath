package symposium;

import guiTeacher.components.Graphic;

public class Card {

	private int rank;
	private String suit;
	private Graphic cardImg;

	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		this.cardImg = new Graphic(0,0,100,100,"cardImages/" + rank + suit + ".png");
	}

}
