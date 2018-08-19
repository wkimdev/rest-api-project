package com.doublechain.ico.response;

import lombok.Getter;
import lombok.Setter;

/**
 * json response class.
 * REST 응답에서 공통으로 들어가는것 : 응답코드, 응답메세지, 데이터
 */
@Getter
@Setter
public class JSONResponse<T> {
	private int code;
	private String msg;
	private T data;
	
	public JSONResponse(){
	}
	
	public JSONResponse(int code, String msg, T data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
}
