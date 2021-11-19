package com.dapp.entities.endpoint3;

public class endpoint3response {
	public endpoint3response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public endpoint3response(int amount, String description, int expiration_minutes, int cashout_amount) {
		super();
		this.amount = amount;
		this.description = description;
		this.expiration_minutes = expiration_minutes;
		this.cashout_amount = cashout_amount;
	}
	private int amount;
	private String description;
	private int expiration_minutes;
	private int cashout_amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getExpiration_minutes() {
		return expiration_minutes;
	}
	public void setExpiration_minutes(int expiration_minutes) {
		this.expiration_minutes = expiration_minutes;
	}
	public int getCashout_amount() {
		return cashout_amount;
	}
	public void setCashout_amount(int cashout_amount) {
		this.cashout_amount = cashout_amount;
	}
	@Override
	public String toString() {
		return "endpoint3response [amount=" + amount + ", description=" + description + ", expiration_minutes="
				+ expiration_minutes + ", cashout_amount=" + cashout_amount + "]";
	}

}