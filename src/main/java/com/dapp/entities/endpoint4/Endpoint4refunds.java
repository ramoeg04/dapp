package com.dapp.entities.endpoint4;

public class Endpoint4refunds {
		public Endpoint4refunds() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Endpoint4refunds(String id, Double amount, String currency, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.date = date;
	}
		private String id;
		private Double amount;
		private String currency;
		private String date;
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
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "Endpoint4refunds [id=" + id + ", amount=" + amount + ", currency=" + currency + ", date=" + date
					+ "]";
		}

}
