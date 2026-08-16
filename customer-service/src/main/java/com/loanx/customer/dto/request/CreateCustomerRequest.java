package com.loanx.customer.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomerRequest {

    @NotBlank(message = "Customer type is required")
    @Size(max = 30, message = "Customer type cannot exceed 30 characters")
    private String customerTypeCode;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name cannot exceed 100 characters")
    private String firstName;

    @Size(max = 100, message = "Middle name cannot exceed 100 characters")
    private String middleName;

    @Size(max = 100, message = "Last name cannot exceed 100 characters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Size(max = 30)
    private String genderCode;

    @Size(max = 30)
    private String maritalStatusCode;

    @Size(max = 200)
    private String fatherName;

    @Size(max = 200)
    private String motherName;

    @Size(max = 200)
    private String spouseName;

    @Size(max = 30)
    private String nationalityCode;

    @Size(max = 30)
    private String occupationCode;

    @Size(max = 30)
    private String sourceCode;

    @Size(max = 100)
    private String createdBy;
}