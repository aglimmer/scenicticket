package com.ticketservice.conductor.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @createDateTime 2020-12-17
 * @Author wonzeng
 */

@Entity
@Table(name = "conductor_ticket_record", schema = "scenicticket", catalog = "")
@ToString
public class ConductorTicketRecord {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private long scenicId;
    private long conductorId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long varifyId;
    private Time enterTime;
    private Time leaveTime;
    private Date orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createDateTime;
    private String ticketType;
    private Double payMoney;
    private Integer ticketSize;
    private String dealNote;
    private Boolean deleted;

    public enum TicketConstant{
        TICKET_ORDER("购票"),
        TICKET_REFOUND("退票");
        @Setter
        @Getter
        private String label;
        TicketConstant(String label) {
            this.label = label;
        }

    }
    public ConductorTicketRecord() {
    }

    public static void main(String[] args) {
        TicketConstant ticket = TicketConstant.TICKET_ORDER;
        System.out.println(ticket.getLabel());
//        System.out.println("Hello World!");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = df.format(timestamp);
//        timestamp = Timestamp.valueOf("1994-04-20 12:13:45");
//        System.out.println(timestamp.toString());
//        Time time = new Time(System.currentTimeMillis());
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
    @Column(name = "scenic_id")
    public long getScenicId() {
        return scenicId;
    }

    public void setScenicId(long scenicId) {
        this.scenicId = scenicId;
    }

    @Basic
    @Column(name = "conductor_id")
    public long getConductorId() {
        return conductorId;
    }

    public void setConductorId(long conductorId) {
        this.conductorId = conductorId;
    }

    @Basic
    @Column(name = "varify_id")
    public long getVarifyId() {
        return varifyId;
    }

    public void setVarifyId(long varifyId) {
        this.varifyId = varifyId;
    }

    @Basic
    @Column(name = "enter_time")
    public Time getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Time enterTime) {
        this.enterTime = enterTime;
    }

    @Basic
    @Column(name = "leave_time")
    public Time getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Time leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        if(StringUtils.isEmpty(createDateTime)){
            this.createDateTime = new Timestamp(System.currentTimeMillis());
            return ;
        }
        this.createDateTime = createDateTime;
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
    @Column(name = "pay_money")
    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    @Basic
    @Column(name = "ticket_size")
    public Integer getTicketSize() {
        return ticketSize;
    }

    public void setTicketSize(Integer ticketSize) {
        this.ticketSize = ticketSize;
    }

    @Basic
    @Column(name = "deal_note")
    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        if(StringUtils.isEmpty(dealNote)){
            this.dealNote = TicketConstant.TICKET_ORDER.getLabel();
            return;
        }
        this.dealNote = dealNote;
    }

    @Basic
    @Column(name = "deleted")
    public Boolean getDeleted() {
        if(this.deleted==null){
            return false;
        }
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConductorTicketRecord that = (ConductorTicketRecord) o;
        return id == that.id &&
                Objects.equals(scenicId, that.scenicId) &&
                Objects.equals(conductorId, that.conductorId) &&
                Objects.equals(varifyId, that.varifyId) &&
                Objects.equals(enterTime, that.enterTime) &&
                Objects.equals(leaveTime, that.leaveTime) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(createDateTime, that.createDateTime) &&
                Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(payMoney, that.payMoney) &&
                Objects.equals(ticketSize, that.ticketSize) &&
                Objects.equals(dealNote, that.dealNote) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scenicId, conductorId, varifyId, enterTime, leaveTime, orderDate, createDateTime, ticketType, payMoney, ticketSize, dealNote, deleted);
    }
}
