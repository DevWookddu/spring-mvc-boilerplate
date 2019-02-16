package io.devwookddu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.RandomStringUtils;

public class StringDigester {
	public static String toSHA256(String str) throws NoSuchAlgorithmException {
		String SHA = "";
		MessageDigest sh = MessageDigest.getInstance("SHA-256");
		sh.update(str.getBytes());
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		SHA = sb.toString();
		return SHA;
	}

	public static String oneTimePassword() throws NoSuchAlgorithmException {
		return toSHA256(RandomStringUtils.randomAlphabetic(10));
	}
}
