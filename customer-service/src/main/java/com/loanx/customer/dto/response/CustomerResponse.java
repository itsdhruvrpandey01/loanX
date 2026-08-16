package com.loanx.customer.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private UUID id;

    private String customerNumber;

    private String customerTypeCode;

    private String customerStatusCode;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String genderCode;

    private String maritalStatusCode;

    private String fatherName;

    private String motherName;

    private String spouseName;

    private String nationalityCode;

    private String occupationCode;

    private String kycStatusCode;

    private String sourceCode;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}