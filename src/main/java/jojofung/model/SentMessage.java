package jojofung.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class SentMessage {

	public String ToUserName;
	
	public String FromUserName;
	
	public String CreateTime;
	
	public String MsgType;
	
	public String Content;

}
