package symposium;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MenuScreen extends FullFunctionScreen { 
	
	private CustomButtonFront quit;
	private CustomButtonFront newbjgame;
	private CustomButtonFront newdicegame;
	private TextArea name;
	private TextArea newbjgametext;
	private TextArea newdicegametext;
	private TextArea quittext;
	
	public MenuScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
			Graphic background = new Graphic(0, 0, 1280, 1040, "resources/menubgrnd.jpg");
			background.setVisible(true);
			viewObjects.add(background);
			StyledComponent.setButtonOutline(true);
			newbjgame = new CustomButtonFront(0, 200, 300, 300);
			newbjgame.setAction(new Action() {
				public void act() {
					MainGame.game.setScreen(MainGame.bj);
				}

			});
			newbjgametext = new TextArea(getWidth()/2 - 45, 472,150,150, "Blackjack");
			
			newdicegame = new CustomButtonFront(0,200,500,500);
			newdicegame.setAction(new Action() {
				public void act() {
					MainGame.game.setScreen(MainGame.dice);
				}

			});
			newdicegametext = new TextArea(getWidth()/2 - 45, 472,150,150, "Cee-Lo");
			
			quit = new CustomButtonFront(1000, 900, 200, 50);
			quit.setAction(new Action() {

				public void act() {
					System.exit(1);
				}

			});
			quittext = new TextArea(1050,900,200,75, "Quit");
			name = new TextArea(640, 520, 400, 400, "Viva Las Vegas");
			
			viewObjects.add(new Graphic(0, 0, getWidth(), getHeight(), "resources/homescreen.png"));
			viewObjects.add(new Graphic(750, 160, 150, 150, "resources/mapleleaf.png"));
			viewObjects.add(quit);
			viewObjects.add(name);
			viewObjects.add(newbjgame);
			viewObjects.add(newdicegame);
			viewObjects.add(newbjgametext);
			viewObjects.add(newdicegametext);
			viewObjects.add(quittext);
		}

	

}
