package com.dapp.entities.endpoint5;

public class Endpoint5card {
	public Endpoint5card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint5card(int last_4, String issuing_bank, String auth_num) {
		super();
		this.last_4 = last_4;
		this.issuing_bank = issuing_bank;
		this.auth_num = auth_num;
	}
	private int last_4;
	private String issuing_bank;
	private String auth_num;
	public int getLast_4() {
		return last_4;
	}
	public void setLast_4(int last_4) {
		this.last_4 = last_4;
	}
	public String getIssuing_bank() {
		return issuing_bank;
	}
	public void setIssuing_bank(String issuing_bank) {
		this.issuing_bank = issuing_bank;
	}
	public String getAuth_num() {
		return auth_num;
	}
	public void setAuth_num(String auth_num) {
		this.auth_num = auth_num;
	}
	@Override
	public String toString() {
		return "Endpoint5card [last_4=" + last_4 + ", issuing_bank=" + issuing_bank + ", auth_num=" + auth_num + "]";
	}

}
