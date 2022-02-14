package com.ncstudy.toolutils;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回码数据结构
 * @author KJS_352
 *
 * @param <T>
 */
@Data
public class ResultDO<T> implements Serializable {

	private static final long serialVersionUID = -3263389845933976059L;
	private boolean success = false;
	private String resultCode;
	private String errorMessage;
	private T data;

	public ResultDO() {
	}

	public ResultDO(String key, boolean result) {
		resultCode = key;
		errorMessage = ResultCode.getValueWithKey(key);
		success = result;
	}

	public ResultDO(String key, String message, boolean result) {
		resultCode = key;
		errorMessage = message + " [" + ResultCode.getValueWithKey(key) + "]";
		success = result;
	}

}
