package jojofung.model.message;

/**
 * For auto-generation will change < into &lt;, so we combine response message
 * manually.
 * 
 * @author jojofeng
 *
 */
public class SentTextMessage extends TextMessage {
	// For received message, so disable this parameter
	protected String MsgId;

	public String generate() {
		return "<xml><ToUserName>" + getCDATAProperty(this.ToUserName) + "</ToUserName><FromUserName>"
				+ getCDATAProperty(this.FromUserName) + "</FromUserName><CreateTime>" + this.CreateTime
				+ "</CreateTime><MsgType>" + getCDATAProperty(this.MsgType) + "</MsgType><Content>"
				+ getCDATAProperty(this.Content) + "</Content></xml>";
	}
}
