package jojofung.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class RecievedMessage {

	public String ToUserName;

	public String FromUserName;

	public String CreateTime;

	public String MsgType;

	public String Content;

	public String MsgId;

}
