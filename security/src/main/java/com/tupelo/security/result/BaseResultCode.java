package com.tupelo.security.result;

/**
 * 
 * @version 1.0
 * @date 2019/9/12 12:19
 */
public enum BaseResultCode implements ResultCode {

	/**
	 * 数据库保存/更新异常
	 */
	UPDATE_DATABASE_ERROR(90001, "Update Database Error"),

	/**
	 * 通用的逻辑校验异常
	 */
	LOGIC_CHECK_ERROR(90004, "Logic Check Error"),

	/**
	 * 恶意请求
	 */
	MALICIOUS_REQUEST(90005, "Malicious Request"),

	/**
	 * 文件上传异常
	 */
	FILE_UPLOAD_ERROR(90006, "File Upload Error"),

	/**
	 * 重复执行
	 */
	REPEATED_EXECUTE(90007, "Repeated execute"),

	/**
	 * 未知异常
	 */
	UNKNOWN_ERROR(99999, "Unknown Error");

	private final Integer code;

	private final String message;

	BaseResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
