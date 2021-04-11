package com.ticketservice.conductor.domain.entity;

import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@Table(name = "conductor_ticket_bill", schema = "scenicticket", catalog = "")
public class ConductorTicketBill {
    /**
     * id依赖于ConductorTicketRecord的ID
     **/
    private long id;
    private Long payerId;
    private Long receiverId;
    private Double dealMoney;
    private Timestamp dealTime;
    private String dealType;

    public ConductorTicketBill() {
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
    @Column(name = "payer_id")
    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    @Basic
    @Column(name = "receiver_id")
    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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
    @Column(name = "deal_time")
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        if(StringUtils.isEmpty(dealTime)){
            this.dealTime = new Timestamp(System.currentTimeMillis());
            return;
        }
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "deal_type")
    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConductorTicketBill that = (ConductorTicketBill) o;
        return id == that.id &&
                Objects.equals(payerId, that.payerId) &&
                Objects.equals(receiverId, that.receiverId) &&
                Objects.equals(dealMoney, that.dealMoney) &&
                Objects.equals(dealTime, that.dealTime) &&
                Objects.equals(dealType, that.dealType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payerId, receiverId, dealMoney, dealTime, dealType);
    }
}
