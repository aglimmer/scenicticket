package com.ticketservice.conductor.domain.entity;

import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@ToString
public class Conductor {
    private Long id;
    private String realname;
    private String sex;
    private String profileImg;
    private String nickname;
    private String phone;
    private String mailbox;
    private String idNumber;
    private Timestamp registerTime;
    private Boolean deleted;

    public Conductor() {
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
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "profile_img")
    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mailbox")
    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
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
    @Column(name = "register_time")
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
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
        Conductor conductor = (Conductor) o;
        return id == conductor.id &&
                Objects.equals(realname, conductor.realname) &&
                Objects.equals(sex, conductor.sex) &&
                Objects.equals(profileImg, conductor.profileImg) &&
                Objects.equals(nickname, conductor.nickname) &&
                Objects.equals(phone, conductor.phone) &&
                Objects.equals(mailbox, conductor.mailbox) &&
                Objects.equals(idNumber, conductor.idNumber) &&
                Objects.equals(registerTime, conductor.registerTime) &&
                Objects.equals(deleted, conductor.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realname, sex, profileImg, nickname, phone, mailbox, idNumber, registerTime, deleted);
    }
}
