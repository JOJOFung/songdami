package jojofung.model.menu;

public class Menu {
	public static final String BUY = "buy";
	public static final String PRODUCT_OIL = "product_oil";
	public static final String PRODUCT_RICE = "product_rice";
	public static final String PRODUCT = "product";
	public static final String CONTACT = "contact";

	public Menu() {
		super();
		this.button[0] = createProductMenu();
		this.button[1] = createBuyMenu();
		this.button[2] = createContactMenu();
	}

	private Button[] button = new Button[3];

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	private static Button createBuyMenu() {
		Button button = new Button();
		button.name = "我要买米";
		button.type = Button.CLICK;
		button.key = BUY;
		return button;
	}

	private static Button createContactMenu() {
		Button button = new Button();
		button.name = "联系我们";
		button.type = Button.CLICK;
		button.key = CONTACT;
		return button;
	}

	private static Button createProductMenu() {
		Button button = new Button();
		button.name = "产品目录";
		button.type = Button.CLICK;
		button.sub_button = new Button[2];
		button.sub_button[0] = createRiceMenu();
		button.sub_button[1] = createOilMenu();
		return button;
	}

	private static Button createRiceMenu() {
		Button button = new Button();
		button.name = "大米";
		button.type = Button.VIEW;
		button.url = "http://54.187.0.133/songdami/jojofung/product/rice.html";
		return button;
	}

	private static Button createOilMenu() {
		Button button = new Button();
		button.name = "食用油";
		button.type = Button.VIEW;
		button.url = "http://54.187.0.133/songdami/jojofung/product/oil.html";
		return button;
	}
}
