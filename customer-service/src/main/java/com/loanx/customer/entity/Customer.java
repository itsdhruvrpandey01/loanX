package com.loanx.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "customer_number", nullable = false, unique = true, length = 50)
    private String customerNumber;

    @Column(name = "customer_type_code", nullable = false, length = 30)
    private String customerTypeCode;

    @Column(name = "customer_status_code", nullable = false, length = 30)
    @Builder.Default
    private String customerStatusCode = "ACTIVE";

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender_code", length = 30)
    private String genderCode;

    @Column(name = "marital_status_code", length = 30)
    private String maritalStatusCode;

    @Column(name = "father_name", length = 200)
    private String fatherName;

    @Column(name = "mother_name", length = 200)
    private String motherName;

    @Column(name = "spouse_name", length = 200)
    private String spouseName;

    @Column(name = "nationality_code", length = 30)
    private String nationalityCode;

    @Column(name = "occupation_code", length = 30)
    private String occupationCode;

    @Column(name = "kyc_status_code", length = 30)
    private String kycStatusCode;

    @Column(name = "source_code", length = 30)
    private String sourceCode;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;
}