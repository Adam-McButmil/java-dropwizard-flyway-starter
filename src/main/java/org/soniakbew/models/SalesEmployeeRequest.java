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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(final String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getNationalInsuranceNo() {
        return nationalInsuranceNo;
    }

    public void setNationalInsuranceNo(final String nationalInsuranceNo) {
        this.nationalInsuranceNo = nationalInsuranceNo;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final float commissionRate) {
        this.commissionRate = commissionRate;
    }
}
