package myStuff;

public class MoveJohnson implements MoveInterfaceJohnson {
	
	private ButtonInterfaceJohnson button;
	
	public MoveJohnson(ButtonInterfaceJohnson button) {
		this.button = button;
	}
	
	public ButtonInterfaceJohnson getButton() {
		return button;
	}

}
