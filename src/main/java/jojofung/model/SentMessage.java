package jojofung.model;

/**
 * For auto-generation will change < into &lt;, so we combine
 * response message manually.
 * 
 * @author jojofeng
 *
 */
public class SentMessage extends Message {

	public String generate() {
		return "<xml><ToUserName>" + getCDATAProperty(this.ToUserName) + "</ToUserName><FromUserName>"
				+ getCDATAProperty(this.FromUserName) + "</FromUserName><CreateTime>" + this.CreateTime
				+ "</CreateTime><MsgType>" + getCDATAProperty(this.MsgType) + "</MsgType><Content>"
				+ getCDATAProperty(this.Content) + "</Content></xml>";
	}
}
