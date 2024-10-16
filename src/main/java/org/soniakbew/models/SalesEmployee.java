package org.soniakbew.models;

public class SalesEmployee {
    private int salesEmployeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String bankAccountNo;
    private String nationalInsuranceNo;
    private float commissionRate;

    public SalesEmployee(
            final int salesEmployeeId,
            final String firstName,
            final String lastName,
            final double salary,
            final String bankAccountNo,
            final String nationalInsuranceNo,
            final float commissionRate) {
        this.salesEmployeeId = salesEmployeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankAccountNo = bankAccountNo;
        this.nationalInsuranceNo = nationalInsuranceNo;
        this.commissionRate = commissionRate;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(final int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
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
