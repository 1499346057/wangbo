package lab6.wangbo.rest;

import com.sun.jersey.core.util.Base64;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class AuthenticationService {

	private static Map<String, String> passwordMap = new HashMap<String, String>() {
		{
			put("user", "Lab6");
		}
	};

	public static boolean authenticate(String authCredentials) {
		if (authCredentials == null) {
			return false;
		}

		String usernameAndPassword = Base64.base64Decode(authCredentials.replaceFirst("Basic ", ""));
		String authValue[] = usernameAndPassword.split(":");
		String login = authValue[0];
		String password = authValue[1];

		if ((login == null) || login.isEmpty()) {
			return false;
		}

		String correctPassword = passwordMap.get(login);
		if ((correctPassword != null) && correctPassword.equals(password)) {
			return true;
		} else
			return false;
	}
}
