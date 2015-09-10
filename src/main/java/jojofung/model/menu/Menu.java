package jojofung.model.menu;

public class Menu {
	public static final String ADDRESS = "address";
	public static final String CONTACT = "contact";

	public Menu() {
		super();
		this.button[0] = createBuyMenu();
		this.button[1] = createContactMenu();
	}

	private Button[] button = new Button[2];

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	private static Button createBuyMenu() {
		Button button = new Button();
		button.name = "我要买米";
		button.type = Button.VIEW;
		button.url = "http://54.187.0.133/songdami/";
		return button;
	}
	
	private static Button createContactMenu() {
		Button button = new Button();
		button.name = "联系我们";
		button.type = Button.CLICK;
		button.key = CONTACT;
		return button;
	}
}
