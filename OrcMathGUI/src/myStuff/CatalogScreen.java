package myStuff;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField priceField;
	private TextField supplyField;
	private TextField barcodeField;
	private TextField isLegalField;
	private Button add;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		nameField = new TextField(40, 40, 200, 30, "Text goes here", "Name");
		viewObjects.add(nameField);
		priceField = new TextField(240, 40, 200, 30, "Text goes here", "Price");
		viewObjects.add(priceField);
		supplyField = new TextField(40, 90, 200, 30, "Text goes here", "Supply");
		viewObjects.add(supplyField);
		barcodeField = new TextField(240, 90, 200, 30, "Text goes here", "Barcode");
		viewObjects.add(barcodeField);
		isLegalField = new TextField(140, 140, 200, 30, "Text goes here", "Is it legal?");
		viewObjects.add(isLegalField);
		add = new Button(10,250,100,40,"Add", new Action() {
			
			@Override
			public void act() {
				nameField.setText("Button clicked");
				
			}
		}
		);
		viewObjects.add(add);
	}

}
