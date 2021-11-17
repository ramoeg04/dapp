package com.dapp.dto;

public class error {

	private int rc;
	private String msg;
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "error [rc=" + rc + ", msg=" + msg + "]";
	}
	public error(int rc, String msg) {
		super();
		this.rc = rc;
		this.msg = msg;
	}
	public error() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
