package com.ticketservice.user.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */
@Entity
@Table(name = "user_user", schema = "scenicticket", catalog = "")
public class UserUser {
    private Long id;
    private Long userId;
    private String authcType;
    private String username;
    private String userpw;
    private String salt;
    private String userType;
    private String state;

    public UserUser() {
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "authc_type")
    public String getAuthcType() {
        return authcType;
    }

    public void setAuthcType(String authcType) {
        this.authcType = authcType;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpw")
    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUser userUser = (UserUser) o;
        return id == userUser.id &&
                userId == userUser.userId &&
                Objects.equals(authcType, userUser.authcType) &&
                Objects.equals(username, userUser.username) &&
                Objects.equals(userpw, userUser.userpw) &&
                Objects.equals(salt, userUser.salt) &&
                Objects.equals(userType, userUser.userType) &&
                Objects.equals(state, userUser.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, authcType, username, userpw, salt, userType, state);
    }
}
