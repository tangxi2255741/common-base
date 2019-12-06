package com.tx.common.exception;

import com.tx.common.sdk.enums.EnumCode;
import com.tx.common.utils.MessageFormatter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description：异常处理
 * @Author：T.X
 * @CreateTime：2019/4/25-10:51
 */
public class AppException extends RuntimeException {
	private static final long serialVersionUID = 6749840708411408254L;
	protected final EnumCode<String> enumCode;
	protected Map<ExtMessage, String> extMessage = new HashMap<ExtMessage, String>();

	public AppException(String message, Throwable cause) {
		super(message, cause);
		enumCode = ErrorCode.SYSTEM_ERROR;
	}

	public AppException(EnumCode<String> code) {
		super(code.getDesc());
		this.enumCode = code;
	}

	public AppException(EnumCode<String> code, String message, Throwable cause) {
		super(message, cause);
		this.enumCode = code;
	}

	public AppException(EnumCode<String> code, String message) {
		super(message);
		this.enumCode = code;
	}

	public AppException(EnumCode<String> code, Throwable cause) {
		super(cause);
		this.enumCode = code;
	}

	public AppException(EnumCode<String> code, String message, Object... args) {
		this(code, message, (Throwable) null, args);
	}

	public AppException(EnumCode<String> code, String message, Throwable cause, Object... args) {
		this(code, MessageFormatter.format(message, args), cause);
	}

	public EnumCode<String> getResponseCode() {
		return enumCode;
	}

	public Map<ExtMessage, String> getExtMessage() {
		return extMessage;
	}

	public AppException extMessage(ExtMessage extMessage, String value) {
		this.extMessage.put(extMessage, value);
		return this;
	}

	public String getAlarmMessage() {
		return getMessage();
	}

}
