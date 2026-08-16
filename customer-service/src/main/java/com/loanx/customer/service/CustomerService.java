package com.loanx.customer.service;

import com.loanx.customer.dto.request.CreateCustomerRequest;
import com.loanx.customer.dto.response.CustomerResponse;

import java.util.UUID;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);

    CustomerResponse getCustomerById(UUID customerId);

    CustomerResponse getCustomerByNumber(String customerNumber);
}