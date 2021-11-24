package com.dapp.entities.endpoint3;

import java.util.List;

public class Endpoint3data {
	
	public Endpoint3data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint3data(String id, String currency, Double amount, String reference, String reference_num,
			String description, String date, int refunded, List<Endpoint3payments> payments, String code,
			Endpoint3terminal terminal, Endpoint3cashout cashout) {
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
		this.terminal = terminal;
		this.cashout = cashout;
	}
	private String id;
	private String currency;
	private Double amount;
	private String reference;
	private String reference_num;
	private String description;
	private String date;
	private int refunded;
	private List <Endpoint3payments> payments;
	private String code;
	private Endpoint3terminal terminal;
	private Endpoint3cashout cashout;
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
	public List<Endpoint3payments> getPayments() {
		return payments;
	}
	public void setPayments(List<Endpoint3payments> payments) {
		this.payments = payments;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Endpoint3terminal getTerminal() {
		return terminal;
	}
	public void setTerminal(Endpoint3terminal terminal) {
		this.terminal = terminal;
	}
	public Endpoint3cashout getCashout() {
		return cashout;
	}
	public void setCashout(Endpoint3cashout cashout) {
		this.cashout = cashout;
	}
	@Override
	public String toString() {
		return "Endpoint3data [id=" + id + ", currency=" + currency + ", amount=" + amount + ", reference=" + reference
				+ ", reference_num=" + reference_num + ", description=" + description + ", date=" + date + ", refunded="
				+ refunded + ", payments=" + payments + ", code=" + code + ", terminal=" + terminal + ", cashout="
				+ cashout + "]";
	}
	
	
}
