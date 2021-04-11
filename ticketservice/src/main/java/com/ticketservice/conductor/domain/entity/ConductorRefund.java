package com.ticketservice.conductor.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @CreateTime 2021-01-03
 * @Author wonzeng
 */
@Data
@ToString
@Entity
@Table(name = "conductor_refund", schema = "scenicticket", catalog = "")
public class ConductorRefund {
    private long id;
    private Long conductorRecordId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp refundDate;
    private Double refundMoney;
    private Integer refundSize;
    private Long conductorBillId;
    private Boolean deleted;

    public ConductorRefund() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

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
    @Column(name = "conductor_record_id")
    public Long getConductorRecordId() {
        return conductorRecordId;
    }

    public void setConductorRecordId(Long conductorRecordId) {
        this.conductorRecordId = conductorRecordId;
    }

    @Basic
    @Column(name = "refund_date")
    public Timestamp getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Timestamp refundDate) {
        if(StringUtils.isEmpty(refundDate)){
            this.refundDate = new Timestamp(System.currentTimeMillis());
            return ;
        }
        this.refundDate = refundDate;
    }

    @Basic
    @Column(name = "refund_money")
    public Double getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Double refundMoney) {
        this.refundMoney = refundMoney;
    }

    @Basic
    @Column(name = "refund_size")
    public Integer getRefundSize() {
        return refundSize;
    }

    public void setRefundSize(Integer refundSize) {
        this.refundSize = refundSize;
    }

    @Basic
    @Column(name = "conductor_bill_id")
    public Long getConductorBillId() {
        return conductorBillId;
    }

    public void setConductorBillId(Long conductorBillId) {
        this.conductorBillId = conductorBillId;
    }

    @Basic
    @Column(name = "deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConductorRefund that = (ConductorRefund) o;
        return id == that.id &&
                Objects.equals(conductorRecordId, that.conductorRecordId) &&
                Objects.equals(refundDate, that.refundDate) &&
                Objects.equals(refundMoney, that.refundMoney) &&
                Objects.equals(refundSize, that.refundSize) &&
                Objects.equals(conductorBillId, that.conductorBillId) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conductorRecordId, refundDate, refundMoney, refundSize, conductorBillId, deleted);
    }
}
