package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Pharmaceuticals extends Component {
	
	private String name;
	private double price;
	private int supply;
	private int barcode;
	private boolean isLegal;
	
	public Pharmaceuticals(String name, double price, int supply, int barcode, boolean isLegal) {
		super(40, 40, 100, 100);
		
		this.name = name;
		this.price = price;
		this.supply = supply;
		this.barcode = barcode;
		this.isLegal = isLegal;
		
		//update();
	}
	public String toString() {
		return name + "," + price + "," + supply + "," + barcode + "," + isLegal;
	}
	
	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

}
