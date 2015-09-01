package jojofung.model.menu;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "button")
public class Button {

	public String type;

	public String name;

	public String key;

	public String url;

	public String media_id;

	public Button[] sub_button;

}
