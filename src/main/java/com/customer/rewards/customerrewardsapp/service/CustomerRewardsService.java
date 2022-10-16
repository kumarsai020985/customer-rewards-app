package com.customer.rewards.customerrewardsapp.service;

import com.customer.rewards.customerrewardsapp.forms.CustomerRequestForm;
import com.customer.rewards.customerrewardsapp.forms.CustomerResponseForm;

public interface CustomerRewardsService  {
	
	
	public void  saveCustomer(CustomerRequestForm customerForm);
	
	public CustomerResponseForm findByCusotmerId(long customerId);

}
