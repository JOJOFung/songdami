package jojofung.accesstoken;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AccessTokenHandler implements ServletContextListener {
	private Thread accessTokenThread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO
		// Change to log
		System.out.println("Stop access token handler thread.");
		accessTokenThread.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		accessTokenThread = new Thread(new AccessTokenQueryThread());
		accessTokenThread.setDaemon(true);
		// TODO
		// Change to log
		System.out.println("Start to retrieve access token....");
		accessTokenThread.start();
	}

}
