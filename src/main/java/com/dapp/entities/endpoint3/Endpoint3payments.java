package com.dapp.entities.endpoint3;

import java.util.List;

public class Endpoint3payments {

	public Endpoint3payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint3payments(String id, Double amount, String currency, int type, String type_description,
			String wallet, String reference_num, List<Endpoint3refunds> refunds, Endpoint3client client,
			Endpoint3card card, Endpoint3codi codi) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.type = type;
		this.type_description = type_description;
		this.wallet = wallet;
		this.reference_num = reference_num;
		this.refunds = refunds;
		this.client = client;
		this.card = card;
		this.codi = codi;
	}
	private String id;
	private Double amount;
	private String currency;
	private int type;
	private String type_description;
	private String wallet;
	private String reference_num;
	private List<Endpoint3refunds> refunds;
	private Endpoint3client client;
	private Endpoint3card card;
	private Endpoint3codi codi;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getType_description() {
		return type_description;
	}
	public void setType_description(String type_description) {
		this.type_description = type_description;
	}
	public String getWallet() {
		return wallet;
	}
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	public String getReference_num() {
		return reference_num;
	}
	public void setReference_num(String reference_num) {
		this.reference_num = reference_num;
	}
	public List<Endpoint3refunds> getRefunds() {
		return refunds;
	}
	public void setRefunds(List<Endpoint3refunds> refunds) {
		this.refunds = refunds;
	}
	public Endpoint3client getClient() {
		return client;
	}
	public void setClient(Endpoint3client client) {
		this.client = client;
	}
	public Endpoint3card getCard() {
		return card;
	}
	public void setCard(Endpoint3card card) {
		this.card = card;
	}
	public Endpoint3codi getCodi() {
		return codi;
	}
	public void setCodi(Endpoint3codi codi) {
		this.codi = codi;
	}
	@Override
	public String toString() {
		return "Endpoint3payments [id=" + id + ", amount=" + amount + ", currency=" + currency + ", type=" + type
				+ ", type_description=" + type_description + ", wallet=" + wallet + ", reference_num=" + reference_num
				+ ", refunds=" + refunds + ", client=" + client + ", card=" + card + ", codi=" + codi + "]";
	}
}
