package com.loanx.customer.repository;

import com.loanx.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByCustomerNumber(String customerNumber);

    boolean existsByCustomerNumber(String customerNumber);
}