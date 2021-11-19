package com.dapp.entities.endpoint6;

public class Endpoint6 {
	public Endpoint6() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endpoint6(int rc, String msg) {
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
		return "Endpoint6 [rc=" + rc + ", msg=" + msg + "]";
	}

}
