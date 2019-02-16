package io.devwookddu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RequestBodyUtil {
	public static Map<String, Object> makeMap(HttpServletRequest request) throws IOException, ParseException {

		BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String buffer;
		while ((buffer = input.readLine()) != null) {
			if (builder.length() > 0) {
				builder.append("\n");
			}
			builder.append(buffer);
		}
		input.close();

		try {
			return (Map<String, Object>) new JSONParser().parse(builder.toString());
		} catch (Exception e) {
			return new HashMap<String, Object>();
		}
	}
}
