package com.dapp.entities.endpoint3;

public class Endpoint3cashout {
	public Endpoint3cashout() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String amount;
	private String currency;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Endpoint3cashout [id=" + id + ", amount=" + amount + ", currency=" + currency + "]";
	}
}
