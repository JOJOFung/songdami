package jojofung;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jojofung.accesstoken.AccessTokenContainer;
import jojofung.model.menu.Button;
import jojofung.model.menu.Menu;
import jojofung.model.message.RecievedMessage;
import jojofung.model.message.SentMessage;
import jojofung.util.Constants;

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
	@Produces({MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN})
	public Response answer(RecievedMessage recievedMsg) {
		SentMessage sentMessage = new SentMessage();
		sentMessage.FromUserName = recievedMsg.ToUserName;
		sentMessage.ToUserName = recievedMsg.FromUserName;
		sentMessage.Content = recievedMsg.Content;
		sentMessage.CreateTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		sentMessage.MsgType = recievedMsg.MsgType;
		System.out.println(AccessTokenContainer.accessToken.access_token);
		return Response.status(Status.OK).entity(sentMessage.generate()).build();
	}
	
	@GET
	@Path("test")
	@Produces({MediaType.APPLICATION_JSON,})
	public Response test() {
		Menu menu = new Menu();
//		WebTarget webTarget = ClientBuilder.newClient().target(Constants.WEIXIN_API_HTTPS_URI);
//		do {
//			try {
//				TimeUnit.MILLISECONDS.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} while (AccessTokenContainer.accessToken.access_token == null);
//		Builder builder = webTarget.path(Constants.CGI_BIN_PATH).path(Constants.MENU_CREATE_PATH)
//				.queryParam(Constants.ACCESS_TOKEN, AccessTokenContainer.accessToken.access_token).request(MediaType.APPLICATION_JSON_TYPE);
		Response response = Response.status(Status.OK).entity(menu).build();
		return response;
	}
}
