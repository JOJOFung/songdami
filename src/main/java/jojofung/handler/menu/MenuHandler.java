package jojofung.handler.menu;

import java.util.concurrent.TimeUnit;

import javax.json.JsonObject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jojofung.model.accesstoken.AccessTokenContainer;
import jojofung.model.menu.Menu;
import jojofung.util.Constants;

public class MenuHandler implements ServletContextListener {
	private static final Logger LOGGER = LogManager.getLogger(MenuHandler.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("Create menues for song_dami....");
		Menu menu = new Menu();
		WebTarget webTarget = ClientBuilder.newClient().target(Constants.WEIXIN_API_HTTPS_URI);
		do {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (AccessTokenContainer.accessToken.access_token == null);
		Builder builder = webTarget.path(Constants.CGI_BIN_PATH).path(Constants.MENU_CREATE_PATH)
				.queryParam(Constants.ACCESS_TOKEN, AccessTokenContainer.accessToken.access_token).request(MediaType.APPLICATION_JSON_TYPE);
		Entity<Menu> entity = Entity.json(menu);
		JsonObject response = builder.post(entity, JsonObject.class);
		LOGGER.info(response);
	}

}
