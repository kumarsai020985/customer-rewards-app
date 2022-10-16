package com.customer.rewards.customerrewardsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.customerrewardsapp.forms.CustomerRequestForm;
import com.customer.rewards.customerrewardsapp.forms.CustomerResponseForm;
import com.customer.rewards.customerrewardsapp.service.CustomerRewardsService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRewardsService customerRewardsService;

	@PostMapping("/customer")
	public void saveCustomerTranaction(@RequestBody CustomerRequestForm customerForm) {
		customerRewardsService.saveCustomer(customerForm);
	}

	
	@GetMapping("/customer/{customerid}")
	public ResponseEntity<?> getCustomerTransactionAndRewardsInfo(@PathVariable("customerid") Long customerid) {

		CustomerResponseForm customer = customerRewardsService.findByCusotmerId(customerid);
		return new ResponseEntity<CustomerRequestForm>(customer, HttpStatus.OK);
	}

}
