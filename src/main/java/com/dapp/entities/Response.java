package com.dapp.entities;

public class Response {

	private int bdRegisterLogExcecution;
	private String message;
	private Object dappData;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(int bdRegisterLogExcecution, String message, Object dappData) {
		super();
		this.bdRegisterLogExcecution = bdRegisterLogExcecution;
		this.message = message;
		this.dappData = dappData;
	}
	@Override
	public String toString() {
		return "Response [bdRegisterLogExcecution=" + bdRegisterLogExcecution + ", message=" + message
				+ ", dappData=" + dappData + "]";
	}
	public int getBdRegisterLogExcecution() {
		return bdRegisterLogExcecution;
	}
	public void setBdRegisterLogExcecution(int bdRegisterLogExcecution) {
		this.bdRegisterLogExcecution = bdRegisterLogExcecution;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String Message) {
		this.message = message;
	}
	public Object getDappData() {
		return dappData;
	}
	public void setDappData(Object dappData) {
		this.dappData = dappData;
	}
	
}
