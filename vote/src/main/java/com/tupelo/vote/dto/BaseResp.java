package com.tupelo.vote.dto;

import lombok.Data;

/**
 * @Author: caichuang
 * @Date: 2023/5/25 15:58
 */
@Data
public class BaseResp {

	private Integer code;
	private String message;
	private Object result;

}
