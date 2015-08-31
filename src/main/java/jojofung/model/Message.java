package jojofung.model;

public class Message {
	public static final String MSG_TEXT_TYPE = getCDATAProperty("text");

	public String ToUserName;

	public String FromUserName;

	public String CreateTime;

	public String MsgType;

	public String Content;

	public static String getCDATAProperty(String property) {
		return "<![CDATA[" + property + "]]>";
	}
}
