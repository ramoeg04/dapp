package com.dapp.entities.endpoint4;

public class Endpoint4 {
	public Endpoint4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint4(int rc, String msg) {
		super();
		this.rc = rc;
		this.msg = msg;
	}
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
		return "Endpoint4 [rc=" + rc + ", msg=" + msg + "]";
	}

}
