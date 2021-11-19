package com.dapp.entities.endpoint5;

public class Endpoint5 {
	public Endpoint5() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endpoint5(int rc, String msg) {
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
		return "Endpoint5 [rc=" + rc + ", msg=" + msg + "]";
	}

}
