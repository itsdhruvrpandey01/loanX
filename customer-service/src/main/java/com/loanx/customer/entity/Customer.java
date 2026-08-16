package com.loanx.customer.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "customers",
    indexes = {
        @Index(name = "idx_customer_customer_number", columnList = "customer_number"),
        @Index(name = "idx_customer_status", columnList = "customer_status_code"),
        @Index(name = "idx_customer_type", columnList = "customer_type_code"),
        @Index(name = "idx_customer_name", columnList = "first_name,last_name")
    }
)
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
    private String customerStatusCode;

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

    @PrePersist
    protected void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        this.createdAt = now;
        this.updatedAt = now;

        if (this.customerStatusCode == null) {
            this.customerStatusCode = "ACTIVE";
        }

        if (this.kycStatusCode == null) {
            this.kycStatusCode = "PENDING";
        }

        if (this.version == null) {
            this.version = 0L;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}