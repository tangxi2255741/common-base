package com.tx.common.utils;

import org.slf4j.helpers.MessageFormatter;


public final class MessageFormats {
	private MessageFormats() {
	}

	public static String concat(Object... args) {
		if (args == null) {
			return null;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (Object o : args) {
			stringBuilder.append(o);
		}
		return stringBuilder.toString();
	}

	public static String format(String pattern, Object... args) {
		return MessageFormatter.arrayFormat(pattern, args).getMessage();
	}
}
