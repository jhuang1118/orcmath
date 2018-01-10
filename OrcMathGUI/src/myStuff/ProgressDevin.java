package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;



import guiTeacher.components.Component;

public class ProgressDevin extends Component implements ProgressInterfaceJohnson {
	private int roundNum;
	private int sequenceNum;
	private boolean lose;
	
	
	public ProgressDevin() {
		super(250,50,400,200);
	}

	@Override
	public void lose() {
		lose = true;
		update();
	} 

	@Override 
	public void update(Graphics2D g) {
			
			clear();
			if(lose) 
			{
				g.setColor(Color.black);
				g.drawString("Game Over.", 0, 50);
			}
			else
			{
				g.setColor(Color.black);
				g.drawString("Round: "+roundNum, 30, 35);
				g.drawString("Sequence: "+sequenceNum, 30, 20);
			}

	}

	@Override
	public void setNum(int roundNum, int sequenceNum) {
		this.roundNum = roundNum;
		this.sequenceNum = sequenceNum;
		update();
	}
	
}