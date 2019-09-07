package com.javabase.javaEight.lambdaAndStream.demo.validation.four;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PatternValidator {
	public static boolean nonNull(Object obj) {
		return obj != null;
	}

	public static void PatternRules(String pattern, String data) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(data);
		if (!m.matches()) {
//			throw new ValidationException("");
		}
	}
}