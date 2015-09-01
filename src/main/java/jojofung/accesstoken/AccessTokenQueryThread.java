package jojofung.accesstoken;

import java.util.concurrent.TimeUnit;

import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import jojofung.model.accesstoken.AccessToken;
import jojofung.util.Constants;

public class AccessTokenQueryThread implements Runnable {
	private static final String EXPIRES_IN = "expires_in";
	private static final String SONGDAMI_SECRET_VALUE = "b2ed2394869ae24801a9c62c73954c8a";
	private static final String SONGDAMI_APPID_VALUE = "wx8fd2bd218f8bf783";
	private static final String SECRET_KEY = "secret";
	private static final String APPID_KEY = "appid";
	private static final String CLIENT_CREDENTIAL = "client_credential";
	private static final String GRANT_TYPE = "grant_type";

	private AccessToken getAccessToken() {
		AccessToken accessToken = new AccessToken();
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		WebTarget webTarget = ClientBuilder.newClient().target(Constants.WEIXIN_API_HTTPS_URI);
		Builder builder = webTarget.path(Constants.CGI_BIN_PATH).path(Constants.TOKEN_PATH)
				.queryParam(GRANT_TYPE, CLIENT_CREDENTIAL).queryParam(APPID_KEY, SONGDAMI_APPID_VALUE)
				.queryParam(SECRET_KEY, SONGDAMI_SECRET_VALUE).request();
		JsonObject responseEntity = builder.get(JsonObject.class);
		String token = responseEntity.getString(Constants.ACCESS_TOKEN);
		int expireSeconds = responseEntity.getInt(EXPIRES_IN);
		accessToken.access_token = token;
		accessToken.expires_in = expireSeconds;
		return accessToken;
	}

	@Override
	public void run() {
		while (true) {
			AccessToken accessToken = getAccessToken();
			AccessTokenContainer.accessToken = accessToken;
			try {
				TimeUnit.SECONDS.sleep(accessToken.expires_in - 8);// Ensure the
																	// token is
																	// always
																	// useful.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
