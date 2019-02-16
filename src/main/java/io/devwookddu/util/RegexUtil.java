package io.devwookddu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	public static final String EMAIL_REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

	public static boolean checkMailAddress(String email) {
		boolean valid = false;
		Pattern p = Pattern.compile(EMAIL_REGEX);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			valid = true;
		}
		return valid;
	}
}
