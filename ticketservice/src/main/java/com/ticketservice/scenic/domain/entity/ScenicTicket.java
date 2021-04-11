package com.ticketservice.scenic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@Table(name = "scenic_ticket", schema = "scenicticket", catalog = "")
@Data
@ToString
public class ScenicTicket {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private Long scenicId;
    private String ticketType;
    private Double discountRate;

    public ScenicTicket() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "scenic_id")
    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    @Basic
    @Column(name = "ticket_type")
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Basic
    @Column(name = "discount_rate")
    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenicTicket that = (ScenicTicket) o;
        return id == that.id &&
                Objects.equals(scenicId, that.scenicId) &&
                Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(discountRate, that.discountRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scenicId, ticketType, discountRate);
    }
}
