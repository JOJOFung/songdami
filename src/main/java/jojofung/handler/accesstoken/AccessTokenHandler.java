package jojofung.handler.accesstoken;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccessTokenHandler implements ServletContextListener {
	private static final Logger LOGGER = LogManager.getLogger(AccessTokenHandler.class);
	
	private Thread accessTokenThread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO
		// Change to log
		LOGGER.info("Stop access token handler thread.");
		accessTokenThread.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		accessTokenThread = new Thread(new AccessTokenQueryThread());
		accessTokenThread.setDaemon(true);
		// TODO
		// Change to log
		LOGGER.info("Start to retrieve access token....");
		accessTokenThread.start();
	}

}
