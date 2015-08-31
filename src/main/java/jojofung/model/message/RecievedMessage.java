package jojofung.model.message;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class RecievedMessage extends Message {

	public String MsgId;

}
