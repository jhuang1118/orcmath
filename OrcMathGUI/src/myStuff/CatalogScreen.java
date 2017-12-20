package myStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiPlayer.Pharmaceuticals;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField priceField;
	private TextField supplyField;
	private TextField barcodeField;
	private TextField isLegalField;
	private TextArea textarea;
	private Button add;
	private CatalogMaker catalog;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		nameField = new TextField(40, 40, 200, 30, "Text goes here", "Name");
		viewObjects.add(nameField);
		priceField = new TextField(240, 40, 200, 30, "Text goes here", "Price");
		priceField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(priceField);
		supplyField = new TextField(40, 90, 200, 30, "Text goes here", "Supply");
		supplyField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(supplyField);
		barcodeField = new TextField(240, 90, 200, 30, "Text goes here", "Barcode");
		barcodeField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(barcodeField);
		isLegalField = new TextField(140, 140, 200, 30, "Text goes here", "Is it legal (True/False)?");
		viewObjects.add(isLegalField);
		textarea = new TextArea(450,40,100,200, "Text");
		viewObjects.add(textarea);
		add = new Button(10,250,100,40,"Add", new Action() {
			
			@Override
			public void act() {
				addButtonClicked();
				
			}
		}
		);
		viewObjects.add(add);
	}

	protected void addButtonClicked() {
		Pharmaceuticals p = new Pharmaceuticals(nameField.getText(), Double.parseDouble(priceField.getText()), 
			Integer.parseInt(supplyField.getText()), Integer.parseInt(barcodeField.getText()), Boolean.parseBoolean(isLegalField.getText()));
		
		String s = textarea.getText() + "\n" + p.toString();
		
		textarea.setText(s);
		
		
		
		nameField.setText("");
		priceField.setText("");
		supplyField.setText("");
		barcodeField.setText("");
		isLegalField.setText("");
	}

}
