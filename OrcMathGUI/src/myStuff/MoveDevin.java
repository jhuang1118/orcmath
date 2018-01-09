package myStuff;

public class MoveDevin implements MoveInterfaceJohnson {
	
	ButtonInterfaceJohnson button;
	
	public MoveDevin(ButtonInterfaceJohnson button) {
		this.button = button;
	}
	
	public ButtonInterfaceJohnson getButton() {
		return button;
	}

}
