package jojofung;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt() {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		WebTarget webTarget = ClientBuilder.newClient().target("https://api.weixin.qq.com");
		Builder builder = webTarget.path("cgi-bin/token").property("grant_type", "client_credential").property("appid", "wx8fd2bd218f8bf783").property("secret", "b2ed2394869ae24801a9c62c73954c8a").request();
		Response response = builder.get();
		Object responseAsString = response.readEntity(Object.class);
		System.out.println(response.getStatus());
		return "";
	}
	
	private String getToken() {
		return "";
	}
}
