package com.dapp.entities.endpoint2;

public class endpoint2request {

	public endpoint2request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public endpoint2request(int amount, String description, int qr_source, int expiration_minutes,
			String cashout_amount) {
		super();
		this.amount = amount;
		this.description = description;
		this.qr_source = qr_source;
		this.expiration_minutes = expiration_minutes;
		this.cashout_amount = cashout_amount;
	}
	private int amount;
	private String description;
	private int qr_source;
	private int expiration_minutes;
	private String cashout_amount;
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
	public int getQr_source() {
		return qr_source;
	}
	public void setQr_source(int qr_source) {
		this.qr_source = qr_source;
	}
	public int getExpiration_minutes() {
		return expiration_minutes;
	}
	public void setExpiration_minutes(int expiration_minutes) {
		this.expiration_minutes = expiration_minutes;
	}
	public String getCashout_amount() {
		return cashout_amount;
	}
	public void setCashout_amount(String cashout_amount) {
		this.cashout_amount = cashout_amount;
	}
	@Override
	public String toString() {
		
		
		return "{amount:" + amount + ", description:" + description + ", qr_source:" + qr_source
				+ ", expiration_minutes:" + expiration_minutes + ", cashout_amount:" + cashout_amount + "}";
	}

}
