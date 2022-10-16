package com.customer.rewards.customerrewardsapp.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionForm {

	private long transactionId;

	private int rewardsPoints;

	private double transactionAmt;


}
