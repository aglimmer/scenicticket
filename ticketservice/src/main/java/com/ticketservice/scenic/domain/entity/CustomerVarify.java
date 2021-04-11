package com.ticketservice.scenic.domain.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@ToString
@Entity
@Table(name = "customer_varify", schema = "scenicticket", catalog = "")
public class CustomerVarify {
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long id;
    private String realName;
    private String idNumber;
    private String phone;

    public CustomerVarify() {
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
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "id_number")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerVarify that = (CustomerVarify) o;
        return id == that.id &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realName, idNumber, phone);
    }
}
