package com.dapp.entities.endpoint4;

import java.util.List;

public class Endpoint4data {

	public Endpoint4data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint4data(String id, String currency, Double amount, String reference, String reference_num,
			String description, String date, int refunded, List<Endpoint4payments> payments, String code) {
		super();
		this.id = id;
		this.currency = currency;
		this.amount = amount;
		this.reference = reference;
		this.reference_num = reference_num;
		this.description = description;
		this.date = date;
		this.refunded = refunded;
		this.payments = payments;
		this.code = code;
	}
	private String id;
	private String currency;
	private Double amount;
	private String reference;
	private String reference_num;
	private String description;
	private String date;
	private int refunded;
	private List <Endpoint4payments> payments;
	private String code;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getReference_num() {
		return reference_num;
	}
	public void setReference_num(String reference_num) {
		this.reference_num = reference_num;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRefunded() {
		return refunded;
	}
	public void setRefunded(int refunded) {
		this.refunded = refunded;
	}
	public List<Endpoint4payments> getPayments() {
		return payments;
	}
	public void setPayments(List<Endpoint4payments> payments) {
		this.payments = payments;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Endpoint4data [id=" + id + ", currency=" + currency + ", amount=" + amount + ", reference=" + reference
				+ ", reference_num=" + reference_num + ", description=" + description + ", date=" + date + ", refunded="
				+ refunded + ", payments=" + payments + ", code=" + code + "]";
	}

}
