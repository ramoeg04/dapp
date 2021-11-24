package com.dapp.entities.endpoint2;

import java.util.List;

public class Endpoint2data {
	public Endpoint2data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint2data(String id, String description, String qr_image, String qr_str, String amount, String currency,
			String cashout, String reference_num, Endpoint2merchant merchant) {
		super();
		this.id = id;
		this.description = description;
		this.qr_image = qr_image;
		this.qr_str = qr_str;
		this.amount = amount;
		this.currency = currency;
		this.cashout = cashout;
		this.reference_num = reference_num;
		this.merchant = merchant;
	}
	private String id;
	private String description;
	private String qr_image;
	private String qr_str;
	private String amount;
	private String currency;
	private String cashout;
	private String reference_num;
	private Endpoint2merchant merchant;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQr_image() {
		return qr_image;
	}
	public void setQr_image(String qr_image) {
		this.qr_image = qr_image;
	}
	public String getQr_str() {
		return qr_str;
	}
	public void setQr_str(String qr_str) {
		this.qr_str = qr_str;
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
	public String getCashout() {
		return cashout;
	}
	public void setCashout(String cashout) {
		this.cashout = cashout;
	}
	public String getReference_num() {
		return reference_num;
	}
	public void setReference_num(String reference_num) {
		this.reference_num = reference_num;
	}
	public Endpoint2merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Endpoint2merchant merchant) {
		this.merchant = merchant;
	}
	@Override
	public String toString() {
		return "Endpoint2data [id=" + id + ", description=" + description + ", qr_image=" + qr_image + ", qr_str="
				+ qr_str + ", amount=" + amount + ", currency=" + currency + ", cashout=" + cashout + ", reference_num="
				+ reference_num + ", merchant=" + merchant + "]";
	}
	
}
