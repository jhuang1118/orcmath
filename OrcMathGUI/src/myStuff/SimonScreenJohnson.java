package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJohnson extends ClickableScreen implements Runnable {
	
	private TextLabel text;
	private static ButtonInterfaceJohnson[] buttons;
	private static ProgressInterfaceJohnson progress;
	private ArrayList<MoveInterfaceJohnson> order;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenJohnson(int width, int height) {
		super(width,height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJohnson b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		order = new ArrayList<MoveInterfaceJohnson>();
		//add 2 moves to start
		lastSelectedButton = -1;
		order.add(randomMove());
		order.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);
		
	}

	private MoveInterfaceJohnson randomMove() {
		
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(bIndex);
	}

	/**
	 * Placeholder until partner finishes implementation of MoveInterface
	 * @param bIndex
	 * @return
	 */
	private MoveInterfaceJohnson getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 * @return
	 */
	private ProgressInterfaceJohnson getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceJohnson[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++) {
			colors[i] = new Color(generateNum(0,255),generateNum(0,255),generateNum(0,255));
			ButtonInterfaceJohnson b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]); 
		    b.setX();
		    b.setY();
		}
		
	}
	
	private int generateNum(int min, int max) {
		return (int)((Math.random() * max) + min);
	}

	/**
	 * Placeholder until partner finishes implementation of ButtonInterface
	 * @return
	 */
	private ButtonInterfaceJohnson getAButton() {
		// TODO Auto-generated method stub
		return null;
	}



}
