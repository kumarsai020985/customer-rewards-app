package com.customer.rewards.customerrewardsapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdNotFounException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CustomerIdNotFounException(String message) {
		super(message);
		this.message = message;
	}

	public CustomerIdNotFounException() {
	}

}