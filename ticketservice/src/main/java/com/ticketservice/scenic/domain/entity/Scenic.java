package com.ticketservice.scenic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@ToString
@Entity
@Table(name = "scenic", schema = "scenicticket", catalog = "")
public class Scenic {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private String scenicName;
    private String scenicImg;
    private String scenicDiscription;
    private Time openTime;
    private Time closeTime;
    private Double fee;
    private String ticketSize;
    private String remainSize;

    public Scenic() {
    }

//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Time tt = Time.valueOf("21:19:00");
////        long aaa = 20210103004107278L;
////        Long bbb = 20210103004107278L;
////        System.out.println("args = " + Long.valueOf("20210103004107278"));
////        System.out.println("args = " + tt.getTime());
//
//    }

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
    @Column(name = "scenic_name")
    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    @Basic
    @Column(name = "scenic_img")
    public String getScenicImg() {
        return scenicImg;
    }

    public void setScenicImg(String scenicImg) {
        this.scenicImg = scenicImg;
    }

    @Basic
    @Column(name = "scenic_discription")
    public String getScenicDiscription() {
        return scenicDiscription;
    }

    public void setScenicDiscription(String scenicDiscription) {
        this.scenicDiscription = scenicDiscription;
    }

    @Basic
    @Column(name = "open_time")
    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    @Basic
    @Column(name = "close_time")
    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "fee")
    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "ticket_size")
    public String getTicketSize() {
        return ticketSize;
    }

    public void setTicketSize(String ticketSize) {
        this.ticketSize = ticketSize;
    }

    @Basic
    @Column(name = "remain_size")
    public String getRemainSize() {
        return remainSize;
    }

    public void setRemainSize(String remainSize) {
        this.remainSize = remainSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenic scenic = (Scenic) o;
        return id == scenic.id &&
                Objects.equals(scenicName, scenic.scenicName) &&
                Objects.equals(scenicImg, scenic.scenicImg) &&
                Objects.equals(scenicDiscription, scenic.scenicDiscription) &&
                Objects.equals(openTime, scenic.openTime) &&
                Objects.equals(closeTime, scenic.closeTime) &&
                Objects.equals(fee, scenic.fee) &&
                Objects.equals(ticketSize, scenic.ticketSize) &&
                Objects.equals(remainSize, scenic.remainSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scenicName, scenicImg, scenicDiscription, openTime, closeTime, fee, ticketSize, remainSize);
    }
}
