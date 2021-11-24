package com.dapp.entities.endpoint5;

import java.util.List;

public class Endpoint5data {

	
	 public Endpoint5data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endpoint5data(String id, Double amount, String currency, String reference_num, int type,
			String type_description, String wallet, List<Endpoint5refunds> refunds, Endpoint5codi codi,
			Endpoint5card card) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.reference_num = reference_num;
		this.type = type;
		this.type_description = type_description;
		this.wallet = wallet;
		this.refunds = refunds;
		this.codi = codi;
		this.card = card;
	}
	private String id;
     private Double amount;
     private String currency;
     private String reference_num;
     private int type;
     private String type_description;
     private String wallet;
     private List <Endpoint5refunds> refunds;
     private Endpoint5codi codi;
     private Endpoint5card card;
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
	public String getReference_num() {
		return reference_num;
	}
	public void setReference_num(String reference_num) {
		this.reference_num = reference_num;
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
	public List<Endpoint5refunds> getRefunds() {
		return refunds;
	}
	public void setRefunds(List<Endpoint5refunds> refunds) {
		this.refunds = refunds;
	}
	public Endpoint5codi getCodi() {
		return codi;
	}
	public void setCodi(Endpoint5codi codi) {
		this.codi = codi;
	}
	public Endpoint5card getCard() {
		return card;
	}
	public void setCard(Endpoint5card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Endpoint5data [id=" + id + ", amount=" + amount + ", currency=" + currency + ", reference_num="
				+ reference_num + ", type=" + type + ", type_description=" + type_description + ", wallet=" + wallet
				+ ", refunds=" + refunds + ", codi=" + codi + ", card=" + card + "]";
	}
	
	

}
