package com.tx.common.utils;

import com.tx.common.sdk.enums.EnumCode;
import com.tx.common.exception.ValidateException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Collection;
import java.util.Map;


public abstract class Validates {
	public static void hasText(String text, EnumCode code) {
		if (StringUtils.isBlank(text)) {
			throw new ValidateException(code);
		}
	}

	public static void hasText(String text, EnumCode code, String message) {
		if (StringUtils.isBlank(text)) {
			throw new ValidateException(code, message);
		}
	}

	public static void notNull(Object obj, EnumCode code) {
		if (obj == null) {
			throw new ValidateException(code);
		}
	}

	public static void notNull(Object obj, EnumCode code, String message) {
		if (obj == null) {
			throw new ValidateException(code, message);
		}
	}

	public static <T> void notEmpty(Collection<T> collection, EnumCode code) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new ValidateException(code);
		}
	}
	public static <T> void notEmpty(Collection<T> collection, EnumCode code, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new ValidateException(code, message);
		}
	}
	
	public static <K, V> void notEmpty(Map<K, V> collection, EnumCode code) {
		if (MapUtils.isEmpty(collection)) {
			throw new ValidateException(code);
		}
	}

	public static void isTrue(boolean result, EnumCode code) {
		if (!result) {
			throw new ValidateException(code);
		}
	}

	public static void isTrue(boolean result, EnumCode code, String message) {
		if (!result) {
			throw new ValidateException(code, message);
		}
	}

	public static void maxLength(String text, int maxLength, EnumCode code) {
		if (text != null && text.trim().length() > maxLength) {
			throw new ValidateException(code);
		}
	}
	public static void maxLength(String text, int maxLength, EnumCode code, String message) {
		if (text != null && text.trim().length() > maxLength) {
			throw new ValidateException(code, message);
		}
	}
	

	public static void size(String text, int min, int max, EnumCode code) {
		int length = 0;
		if (text != null && (length = text.trim().length()) >= min && length <= max) {
			throw new ValidateException(code);
		}
	}
}
