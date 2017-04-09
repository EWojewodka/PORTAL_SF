package pl.jemiol.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validation {

	public static boolean ofEmail(String email) {
		boolean result = true;
		try {
			InternetAddress address = new InternetAddress(email);
			address.validate();
		} catch (AddressException e) {
			result = false;
		}
		return result;
	}

	public static boolean ofPassword(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}
}
