package com.dapp.entities.endpoint5;

public class endpoint5request {
	public endpoint5request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public endpoint5request(int amount) {
		super();
		this.amount = amount;
	}

	public int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "endpointrequest7 [amount=" + amount + "]";
	}

}
