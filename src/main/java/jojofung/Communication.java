package jojofung;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jojofung.model.message.EventMessage;
import jojofung.model.message.Message;
import jojofung.model.message.SentTextMessage;
import jojofung.model.message.TextMessage;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class Communication {
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
	@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	// MediaType.APPLICATION_XML for test
	// MediaType.TEXT_XML is weixin's real environment
	public Response answer(Message msg) {
		if (TextMessage.MSG_TEXT_TYPE.equals(msg.MsgType)) {
			//ReceivedTextMessage recievedMsg = (ReceivedTextMessage) msg;
			Message recievedMsg = msg;
			
			SentTextMessage sentMessage = new SentTextMessage();
			sentMessage.FromUserName = recievedMsg.ToUserName;
			sentMessage.ToUserName = recievedMsg.FromUserName;
			sentMessage.Content = recievedMsg.Content;
			sentMessage.CreateTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
			sentMessage.MsgType = SentTextMessage.MSG_TEXT_TYPE;
			return Response.status(Status.OK).entity(sentMessage.generate()).build();
		} else if (EventMessage.MSG_EVENT_TYPE.equals(msg.MsgType)) {
			//EventMessage event = (EventMessage) msg;
			Message event = msg;
			
			System.out.println(event);
		}
		return Response.status(Status.OK).entity("").build();
	}

}
