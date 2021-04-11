package com.ticketservice.scenic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@Table(name = "customer_account", schema = "scenicticket", catalog = "")
public class CustomerAccount {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private Long customerId;
    private String acconutName;
    private Double balance;
    private String paymentCode;

    public CustomerAccount() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "acconut_name")
    public String getAcconutName() {
        return acconutName;
    }

    public void setAcconutName(String acconutName) {
        this.acconutName = acconutName;
    }

    @Basic
    @Column(name = "balance")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "payment_code")
    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAccount that = (CustomerAccount) o;
        return id == that.id &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(acconutName, that.acconutName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(paymentCode, that.paymentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, acconutName, balance, paymentCode);
    }
}
