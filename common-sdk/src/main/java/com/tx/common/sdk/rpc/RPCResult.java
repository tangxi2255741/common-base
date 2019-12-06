package com.tx.common.sdk.rpc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 对外服务返回结果
 */

public class RPCResult<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 6618340620203726515L;
    public static final String SUCCESS_CODE = "0000";

	/** RPC调用「成功/失败」标识 */
	private boolean success;
	/** 错误码 */
    private String code = SUCCESS_CODE;
    /** 错误信息 */
    private String errorMsg;
    /** 返回的扩展信息 */
    private HashMap<String, String> extMessage;
    /** RPC调用结果 */
    private T result;
    /** 跟踪日志id */
    private String traceId;
    
    /**
     * 创建一个调用成功响应
     *
     * @return {@linkplain RPCResult}
     */
    public static <E extends Serializable> RPCResult<E> success() {
        return new RPCResult<E>().setSuccess(true).setResult(null);
    }

    /**
     * 创建一个调用成功响应，并且返回对应的code
     *
     */
    public static <E extends Serializable> RPCResult<E> success(String code) {
        return new RPCResult<E>().setSuccess(true).setCode(code);
    }

    /**
     * 创建一个调用成功响应
     *
     * @param e 响应内容
     * @return {@linkplain RPCResult}
     */
    public static <E extends Serializable> RPCResult<E> success(E e) {
        return new RPCResult<E>().setSuccess(true).setResult(e);
    }

    /**
     * 创建一个调用失败响应
     *
     * @param code 错误码
     * @return {@linkplain RPCResult}
     */
    public static <E extends Serializable> RPCResult<E> failure(String code) {
        return failure(code, null, null);
    }

    /**
     * 创建一个调用失败响应
     *
     * @param code 错误码
     * @param message 错误信息
     * @return {@linkplain RPCResult}
     */
    public static <E extends Serializable> RPCResult<E> failure(String code, String message) {
        return failure(code, message, null);
    }

    /**
     * 创建一个调用失败响应
     *
     * @param code 错误码
     * @param message 错误信息
     * @param e 响应内容
     * @return {@linkplain RPCResult}
     */
    public static <E extends Serializable> RPCResult<E> failure(String code, String message, E e) {
        return new RPCResult<E>().setSuccess(false).setCode(code).setErrorMsg(message).setResult(e);
    }

    /**
     * 判断RPC请求「成功/失败」
     *
     * @return true-成功,false-失败
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置RPC请求「成功/失败」
     *
     * @param success true-成功,false-失败
     * @return self
     */
    public RPCResult<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    /**
     * 获取错误码
     *
     * @return 字符串类型的错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置错误码
     *
     * @param code 错误码
     * @return self
     */
    public RPCResult<T> setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 获取错误信息
     *
     * @return
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误信息
     *
     * @param errorMsg
     * @return self
     */
    public RPCResult<T> setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    /**
     * 获取扩展信息
     *
     * @return
     */
    public Map<String, String> getExtMessage() {
        return extMessage;
    }

    /**
     * 设置扩展信息
     *
     * @param extMessage
     * @return self
     */
    public RPCResult<T> setExtMessage(HashMap<String, String> extMessage) {
        this.extMessage = extMessage;
        return this;
    }

    /**
     * 获取RPC调用结果
     *
     * @return
     */
    public T getResult() {
        return result;
    }

    /**
     * 设置RPC调用结果
     *
     * @param result
     */
    public RPCResult<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
