package com.dapp.entities.endpoint3;

public class Endpoint3codi {
public Endpoint3codi() {
		super();
		// TODO Auto-generated constructor stub
	}
public Endpoint3codi(String codi_id, int account_type, String account_number, int issuing_bank) {
		super();
		this.codi_id = codi_id;
		this.account_type = account_type;
		this.account_number = account_number;
		this.issuing_bank = issuing_bank;
	}
private String codi_id;
private int account_type;
private String account_number;
private int issuing_bank;
public String getCodi_id() {
	return codi_id;
}
public void setCodi_id(String codi_id) {
	this.codi_id = codi_id;
}
public int getAccount_type() {
	return account_type;
}
public void setAccount_type(int account_type) {
	this.account_type = account_type;
}
public String getAccount_number() {
	return account_number;
}
public void setAccount_number(String account_number) {
	this.account_number = account_number;
}
public int getIssuing_bank() {
	return issuing_bank;
}
public void setIssuing_bank(int issuing_bank) {
	this.issuing_bank = issuing_bank;
}
@Override
public String toString() {
	return "Endpoint5codi [codi_id=" + codi_id + ", account_type=" + account_type + ", account_number=" + account_number
			+ ", issuing_bank=" + issuing_bank + "]";
}
}
