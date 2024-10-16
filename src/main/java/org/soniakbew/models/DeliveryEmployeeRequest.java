package org.soniakbew.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private final String name;
    private final Double salary;
    private final String bankAccountNumber;
    private final String nationalInsuranceNumber;

    @JsonCreator
    public DeliveryEmployeeRequest(
            final @JsonProperty("name") String name,
            final @JsonProperty("salary") Double salary,
            final @JsonProperty("bankAccountNumber") String bankAccountNumber,
            final @JsonProperty(
                    "nationalInsuranceNumber"
            ) String nationalInsuranceNumber
    ) {
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }
}
