package myStuff;

import guiTeacher.GUIApplication;

public class SimonClassJohnson extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4360504300565526601L;
	public static SimonClassJohnson game;
	public static SimonScreenJohnson screen;

	public SimonClassJohnson(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenJohnson screen = new SimonScreenJohnson(getWidth(),getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonClassJohnson game = new SimonClassJohnson(800,800);
		Thread runner = new Thread(game);
		runner.start();
	}

}
