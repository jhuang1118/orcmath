package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	
	private ArrayList <Pharmaceuticals> list;
	private boolean wantsToAdd;
	
	public CatalogMaker() {
		list = new ArrayList <Pharmaceuticals>();
		list.add(new Pharmaceuticals("Tylenol", 4.99, 50, 01, true));
		list.add(new Pharmaceuticals("Advil", 6.99, 50, 02, true));
		list.add(new Pharmaceuticals("Cough medicine", 8.99, 50, 03, true));
		list.add(new Pharmaceuticals("Antihistamines", 13.99, 50, 04, true));
		list.add(new Pharmaceuticals("Eye Drops", 2.99, 50, 05, true));
		list.add(new Pharmaceuticals("Marijuana", 49.99, 50, 02, true));
		list.add(new Pharmaceuticals("Cocaine", 999.99, 50, 02, true));
		list.add(new Pharmaceuticals("LSD", 1099.99, 50, 02, true));
		list.add(new Pharmaceuticals("Ketamine", 899.99, 50, 02, true));
		list.add(new Pharmaceuticals("Crack Cocaine", 599.99, 50, 02, true));
	}

	public static void main(String[] args) {
		CatalogMaker catalog = new CatalogMaker();
		System.out.println(catalog.getCSVContent());
		Scanner in = new Scanner(System.in);
		
		System.out.println("Would you like to add another item?");
		String input = in.nextLine();
		if((input.toLowerCase()).equals("yes")) {
			
		}
	}
	
	public void addNewItem(String name, double price, int supply, int barcode, boolean isLegal) {
		list.add(new Pharmaceuticals(name, price, supply, barcode, isLegal));
		
		System.out.println("Item added successfully");
	}
	
	public String getCSVContent() {
		String data = "Name, Price, Supply, Barcode, isLegal \n";
		for(Pharmaceuticals p: list) {
			data += p.toString() + "\n";
		}
		return data;
	}
}
