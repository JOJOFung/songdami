package jojofung.model.message;

public class EventMessage extends Message {
	public static final String MSG_EVENT_TYPE = "event";
	
	// For text message, so disable this parameter
	protected String Content;

	// For received message, so disable this parameter
	protected String MsgId;
}
