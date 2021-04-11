package com.ticketservice.scenic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@Table(name = "customer_recharge", schema = "scenicticket", catalog = "")
public class CustomerRecharge {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long customerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long conductorId;
    private String dealType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp dealTime;
    private Double dealMoney;
    private Long openAcconutId;

    public CustomerRecharge() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @Column(name = "conductor_id")
    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }

    @Basic
    @Column(name = "deal_type")
    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    @Basic
    @Column(name = "deal_time")
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "deal_money")
    public Double getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(Double dealMoney) {
        this.dealMoney = dealMoney;
    }

    @Basic
    @Column(name = "open_acconut_id")
    public Long getOpenAcconutId() {
        return openAcconutId;
    }

    public void setOpenAcconutId(Long openAcconutId) {
        this.openAcconutId = openAcconutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRecharge that = (CustomerRecharge) o;
        return id == that.id &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(conductorId, that.conductorId) &&
                Objects.equals(dealType, that.dealType) &&
                Objects.equals(dealTime, that.dealTime) &&
                Objects.equals(dealMoney, that.dealMoney) &&
                Objects.equals(openAcconutId, that.openAcconutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, conductorId, dealType, dealTime, dealMoney, openAcconutId);
    }
}
