package com.loanx.customer.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanx.customer.dto.request.CreateCustomerRequest;
import com.loanx.customer.dto.response.CustomerResponse;
import com.loanx.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @Valid @RequestBody CreateCustomerRequest request) {

        CustomerResponse response =
                customerService.createCustomer(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(
            @PathVariable UUID customerId) {

        return ResponseEntity.ok(
                customerService.getCustomerById(customerId)
        );
    }

    @GetMapping("/number/{customerNumber}")
    public ResponseEntity<CustomerResponse> getCustomerByNumber(
            @PathVariable String customerNumber) {

        return ResponseEntity.ok(
                customerService.getCustomerByNumber(customerNumber)
        );
    }
}