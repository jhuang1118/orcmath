package symposium;

import java.util.ArrayList;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	public static MainGame game;
	public static MainScreen main;
	public static BlackjackScreen bj;
	public static MenuScreen menu;
	public static DiceScreen dice;
	public ArrayList<Card> deck;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1040);
		Thread runner = new Thread(game);
		runner.start();
		
	}

	@Override
	public void initScreen() {
		createCards();
		createDice();
		
	}

	private void createDice() {
		// TODO Auto-generated method stub
		
	}

	private void createCards() {
		
		
	}

}
