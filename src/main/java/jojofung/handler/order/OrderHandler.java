package jojofung.handler.order;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jojofung.model.order.Order;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("order")
public class OrderHandler {
	private static final Logger LOGGER = LogManager.getLogger(OrderHandler.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String allOrders(@QueryParam("user") String user) {
		return "";
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response receive(Order order) {
		LOGGER.info("Received an order: Please send " + order.goods + " to " + order.address);
		return Response.status(Status.OK).entity("success").build();
	}

}
