package com.tupelo.security.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * 
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	private T data;

	public R(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public R(String message, T data) {
		this.message = message;
		this.data = data;
	}

	public R(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public R() {
	}

	public static <T> R<T> ok() {
		return ok(null);
	}

	public static <T> R<T> ok(T data) {
		return ok(data, SystemResultCode.SUCCESS.getMessage());
	}

	public static <T> R<T> ok(T data, String message) {
		return new R<T>(SystemResultCode.SUCCESS.getCode(),message,data);
	}

	public static <T> R<T> failed(int code, String message) {
		return new R<T>(code,message);
	}

	public static <T> R<T> failed(ResultCode failMsg) {
		return failed(failMsg.getCode(), failMsg.getMessage());
	}

	public static <T> R<T> failed(ResultCode failMsg, String message) {
		return failed(failMsg.getCode(), message);
	}


}
