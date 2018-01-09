package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import com.itextpdf.text.Font;

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
		if(lose) {
			g.setColor(Color.RED);
			g.fillRect(300, 0, 200, 100);
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,10,55);
			g.drawString("Current Sequence Length: "+sequenceNum,5,100);
			g.drawString("LOL YOU CAN'T EVEN PLAY A KID GAME",5,150);
		}else {
			g.setColor(Color.GREEN);
			g.fillRect(300, 0, 200, 100);
			g.setColor(Color.black);
			g.drawString("Round: "+roundNum,5,55);
			g.drawString("Current Sequence Length: "+sequenceNum,5,100);
		}

	}
	@Override
	public void setRound(int x) {
		this.roundNum = x;
		update();
	}

	@Override
	public void setSequenceSize(int x) {
		this.sequenceNum = x;
		update();
	}
}