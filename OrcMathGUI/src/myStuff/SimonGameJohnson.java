package myStuff;

import guiPlayer.CatalogScreen;
import guiTeacher.GUIApplication;

public class SimonGameJohnson extends GUIApplication {
	
	private static final long serialVersionUID = 7548071104587737267L;

	public SimonGameJohnson(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		SimonGameJohnson game = new SimonGameJohnson(600,600);
		Thread runner = new Thread(game);
		runner.start();
	}

	@Override
	public void initScreen() {
		SimonScreenJohnson screen = new SimonScreenJohnson(getWidth(), getHeight());
		setScreen(screen);
		
	}

}
