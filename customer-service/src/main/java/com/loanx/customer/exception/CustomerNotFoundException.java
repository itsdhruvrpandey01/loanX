package com.loanx.customer.exception;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

   	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(UUID customerId) {
        super("Customer not found with id: " + customerId);
    }

    public CustomerNotFoundException(String customerNumber) {
        super("Customer not found with customer number: " + customerNumber);
    }
}