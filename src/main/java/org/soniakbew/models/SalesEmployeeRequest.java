package org.soniakbew.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {

    private String firstName;
    private String lastName;
    private double salary;
    private String bankAccountNo;
    private String nationalInsuranceNo;
    private float commissionRate;

    @JsonCreator
    public SalesEmployeeRequest(
            final @JsonProperty("firstName") String firstName,
            final @JsonProperty("lastName") String lastName,
            final @JsonProperty("salary") double salary,
            final @JsonProperty("bankAccountNo") String bankAccountNo,
            final @JsonProperty(
                    "nationalInsuranceNo"
            ) String nationalInsuranceNo,
            final @JsonProperty("commissionRate") float commissionRate
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankAccountNo = bankAccountNo;
        this.nationalInsuranceNo = nationalInsuranceNo;
        this.commissionRate = commissionRate;
    }
}
