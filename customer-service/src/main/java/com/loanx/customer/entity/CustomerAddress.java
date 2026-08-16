package com.loanx.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer_addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAddress {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "address_type_code", nullable = false, length = 30)
    private String addressTypeCode;

    @Column(name = "address_line_1", nullable = false, length = 255)
    private String addressLine1;

    @Column(name = "address_line_2", length = 255)
    private String addressLine2;

    @Column(name = "landmark", length = 255)
    private String landmark;

    @Column(name = "country_code", length = 30)
    private String countryCode;

    @Column(name = "state_code", length = 30)
    private String stateCode;

    @Column(name = "district_code", length = 30)
    private String districtCode;

    @Column(name = "city_code", length = 30)
    private String cityCode;

    @Column(name = "pincode_code", length = 30)
    private String pincodeCode;

    @Column(name = "is_primary", nullable = false)
    private Boolean primary = false;

    @Column(name = "status_code", nullable = false, length = 30)
    private String statusCode = "ACTIVE";

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