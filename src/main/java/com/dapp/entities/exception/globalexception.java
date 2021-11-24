package com.dapp.entities.exception;

import java.io.Serializable;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class globalexception extends RuntimeException implements Serializable {

	public globalexception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public globalexception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public globalexception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public globalexception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public globalexception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public globalexception(int bdRegisterLogExcecution, String message, Object dappData) {
		super();
		this.bdRegisterLogExcecution = bdRegisterLogExcecution;
		this.message = message;
		this.dappData = dappData;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6788153460214223068L;
	private int bdRegisterLogExcecution;
	private String message;
	private Object dappData;

	public int getBdRegisterLogExcecution() {
		return bdRegisterLogExcecution;
	}

	public void setBdRegisterLogExcecution(int bdRegisterLogExcecution) {
		this.bdRegisterLogExcecution = bdRegisterLogExcecution;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDappData() {
		return dappData;
	}

	public void setDappData(Object dappData) {
		this.dappData = dappData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "globalexception [bdRegisterLogExcecution=" + bdRegisterLogExcecution + ", message=" + message
				+ ", dappData=" + dappData + "]";
	}

}
