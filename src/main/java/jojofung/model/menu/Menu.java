package jojofung.model.menu;

public class Menu {
	public Menu() {
		super();
		this.button[0] = createOneMenu();
	}

	private Button[] button = new Button[1];

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	private static Button createOneMenu() {
		Button button = new Button();
		button.name = "我要买米";
		button.type = "click";
		button.key = "mai";
		return button;
	}

}
