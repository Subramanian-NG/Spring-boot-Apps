package com.example.thymeleafdemo.model;

import com.example.thymeleafdemo.validation.CouponCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull(message = "field required")
    @Size(min = 1, message = "field required")
    private String lastName = "";

    @Min(value = 1, message = "minimum number of tickets is 1")
    @Max(value = 10, message = "maximum number of tickets is 10")
    @NotNull(message = "field required")
    private Integer noOfTickets;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only numbers and characters allowed and max length is 5")
    private String postalCode;

    @CouponCode(value = "TOP", message = "must start with TOP")
    private String couponCode;

    public Customer() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNoOfTickets() {
        return this.noOfTickets;
    }

    public void setNoOfTickets(Integer noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "{" +
                " firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", noOfTickets='" + getNoOfTickets() + "'" +
                ", postalCode='" + getPostalCode() + "'" +
                ", couponCode='" + getCouponCode() + "'" +
                "}";
    }

}