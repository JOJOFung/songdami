package jojofung;

import java.util.Calendar;

import javax.json.JsonObject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import jojofung.model.RecievedMessage;
import jojofung.model.SentMessage;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@QueryParam("signature") String signature, @QueryParam("timestamp") String timestamp,
			@QueryParam("nonce") String nonce, @QueryParam("echostr") String echostr) {
		return echostr;
	}

	@POST
	@Consumes({MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	@Produces({MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
	public SentMessage answer(RecievedMessage recievedMsg) {
		SentMessage sentMessage = new SentMessage();
		sentMessage.FromUserName = recievedMsg.ToUserName;
		sentMessage.ToUserName = recievedMsg.FromUserName;
		sentMessage.Content = recievedMsg.Content;
		sentMessage.CreateTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		sentMessage.MsgType = "<![CDATA[你好]]>";
		return sentMessage;
	}

	private String getToken() {
		//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		WebTarget webTarget = ClientBuilder.newClient().target("https://api.weixin.qq.com");
		Builder builder = webTarget.path("cgi-bin/token").queryParam("grant_type", "client_credential")
				.queryParam("appid", "wx8fd2bd218f8bf783").queryParam("secret", "b2ed2394869ae24801a9c62c73954c8a")
				.request();
		JsonObject responseEntity = builder.get(JsonObject.class);
		String token = responseEntity.getString("access_token");
		return token;
	}
}
