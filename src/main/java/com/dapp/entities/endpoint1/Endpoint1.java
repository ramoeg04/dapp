package com.dapp.entities.endpoint1;

import java.util.List;

public class Endpoint1 {
	public Endpoint1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint1(int rc, String msg, List<Endpoint1data> data) {
		super();
		this.rc = rc;
		this.msg = msg;
		this.data = data;
	}
	private int rc;
	private String msg;
	private List<Endpoint1data> data;


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
	public List<Endpoint1data> getData() {
		return data;
	}
	public void setData(List<Endpoint1data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Endpoint1 [rc=" + rc + ", msg=" + msg + ", data=" + data + "]";
	}


}
