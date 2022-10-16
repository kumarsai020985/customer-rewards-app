package com.customer.rewards.customerrewardsapp.forms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerRequestForm {

	private long customerId;

	private String customerName;

	private List<Double> itemPrices;

}
