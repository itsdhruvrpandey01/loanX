package com.loanx.customer.mapper;

import com.loanx.customer.dto.request.CreateCustomerRequest;
import com.loanx.customer.dto.response.CustomerResponse;
import com.loanx.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CreateCustomerRequest request) {

        return Customer.builder()
                .customerTypeCode(request.getCustomerTypeCode())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .genderCode(request.getGenderCode())
                .maritalStatusCode(request.getMaritalStatusCode())
                .fatherName(request.getFatherName())
                .motherName(request.getMotherName())
                .spouseName(request.getSpouseName())
                .nationalityCode(request.getNationalityCode())
                .occupationCode(request.getOccupationCode())
                .sourceCode(request.getSourceCode())
                .createdBy(request.getCreatedBy())
                .updatedBy(request.getCreatedBy())
                .build();
    }

    public CustomerResponse toResponse(Customer customer) {

        return CustomerResponse.builder()
                .id(customer.getId())
                .customerNumber(customer.getCustomerNumber())
                .customerTypeCode(customer.getCustomerTypeCode())
                .customerStatusCode(customer.getCustomerStatusCode())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .genderCode(customer.getGenderCode())
                .maritalStatusCode(customer.getMaritalStatusCode())
                .fatherName(customer.getFatherName())
                .motherName(customer.getMotherName())
                .spouseName(customer.getSpouseName())
                .nationalityCode(customer.getNationalityCode())
                .occupationCode(customer.getOccupationCode())
                .kycStatusCode(customer.getKycStatusCode())
                .sourceCode(customer.getSourceCode())
                .createdAt(customer.getCreatedAt())
                .createdBy(customer.getCreatedBy())
                .updatedAt(customer.getUpdatedAt())
                .updatedBy(customer.getUpdatedBy())
                .build();
    }
}