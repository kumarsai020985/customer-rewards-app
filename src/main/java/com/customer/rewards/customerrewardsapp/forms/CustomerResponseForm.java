package com.customer.rewards.customerrewardsapp.forms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties("itemPrices")
public class CustomerResponseForm extends CustomerRequestForm {

	private List<TransactionForm> trasactionsForm;
	
	private int totalRewardsPoints;
	
	

}
