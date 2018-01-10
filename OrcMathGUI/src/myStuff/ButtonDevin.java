package myStuff;

import java.awt.Color;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDevin extends Button implements ButtonInterfaceJohnson {
	
	
	private Color buttonColor;

	public ButtonDevin(int x, int y, int w, int h, String text, Action action) {
		super(x+20, y, w, h, "", null);
		update();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(Color color) {
		this.buttonColor = color;
		this.setBackground(color);
		update();
	}
	public void highlight() {
		this.setBackground(Color.black);
		update();

	}

	@Override
	public void dim() {
		this.setBackground(this.buttonColor);
		update();

	}

	

}
