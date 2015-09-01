package jojofung.model.message;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class Message {

	// Base elements
	public String ToUserName;

	public String FromUserName;

	public String CreateTime;

	public String MsgType;

	// For event
	public String Event;

	public String EventKey;

	// For text message
	public String Content;

	// For received message
	public String MsgId;

	public static String getCDATAProperty(String property) {
		return "<![CDATA[" + property + "]]>";
	}
}
