package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJohnson extends ClickableScreen implements Runnable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 496661046915956149L;
	public ProgressInterfaceJohnson progress;
	public ArrayList<MoveInterfaceJohnson> sequence;
	
	public int increment;
	public TextLabel label;
	public ButtonInterfaceJohnson[] buttons;
	public int roundNumber;
	public boolean acceptingInput;
	public int sequenceIndex;
	Color[] colors;
	public int lastSelectedButton;
	
	
	public SimonScreenJohnson(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	
	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		increment++;
		
		progress.setNum(roundNumber, sequence.size());
		sequence.add(randomMove());
		
		changeText("Simon's turn");
		
		playSequence();
		
		changeText("Your turn");
		sequenceIndex = 0;
		acceptingInput = true;
	}
	public void playSequence() {
		
		ButtonInterfaceJohnson b;
		for(int i = 0; i < sequence.size(); i++) {
			
			b = sequence.get(i).getButton();
			b.highlight();
			int sleepTime = (int) Math.log(Math.pow(2, roundNumber)) + 3;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.dim();
		}
		
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		sequence = new ArrayList<MoveInterfaceJohnson>();
		lastSelectedButton = -1;
		
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceJohnson[numberOfButtons];
		colors = new Color[numberOfButtons];
		colors[0] = Color.blue;
		colors[1] = Color.red;
		colors[2] = Color.green;
		colors[3] = Color.yellow;
		colors[4] = Color.orange;
		
		roundNumber = 0;
		sequenceIndex = 0;
		increment = 3;
		acceptingInput = true;
		
		label = new TextLabel(70,100,300,40,"Let's play Simon!");
		viewObjects.add(label);

		for(int j = 0; j < buttons.length; j++) {
			final ButtonInterfaceJohnson b = getButton(50,j*70+70,60,60);
			buttons[j] = b;
			b.setColor(colors[j]);
			b.setAction(new Action(){
				
				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								acceptingInput = true;
								b.dim();
							}
						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}
						else {
							progress.lose();
							acceptingInput = false;
						}
						if(sequenceIndex == sequence.size()){ 
						    Thread nextRound = new Thread(SimonScreenJohnson.this); 
						    nextRound.start(); 
						}
					}
				}
				
			});
			
			progress = getProgress();
			progress.setNum(roundNumber, increment);
			sequence.add(randomMove());
			sequence.add(randomMove());
			
			for(int i = 0; i < buttons.length; i++){ 
			    System.out.println(buttons[i]);
				viewObjects.add(buttons[i]); 
			}
			viewObjects.add(progress);
		}
	}

	public MoveInterfaceJohnson randomMove() {
		int selectedButton = (int)(Math.random()*buttons.length);
		while(selectedButton == lastSelectedButton) {
			selectedButton = (int)(Math.random()*buttons.length);
		}
		//lastSelectedButton = selectedButton;
		return getMove(selectedButton);
	}

	private MoveInterfaceJohnson getMove(int selectedButton) {
		return new MoveJohnson(buttons[selectedButton]);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceJohnson getProgress() { 
	   return new ProgressJohnson();
	}
	
	private ButtonInterfaceJohnson getButton(int x, int y, int w, int h) {
		ButtonJohnson button = new ButtonJohnson(x,y,w,h,"", null);
		return button;
	}
	
	

	
	public void changeText(String text) {
		Thread changer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				label.setText(text);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText("");
			}
		});
		changer.start();
	}
	
	  

}
