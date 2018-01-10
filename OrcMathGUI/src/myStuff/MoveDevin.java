package myStuff;

public class MoveDevin implements MoveInterfaceJohnson {
	
	private ButtonInterfaceJohnson button;
	
	public MoveDevin(ButtonInterfaceJohnson button) {
		this.button = button;
	}
	
	public ButtonInterfaceJohnson getButton() {
		return button;
	}

}
