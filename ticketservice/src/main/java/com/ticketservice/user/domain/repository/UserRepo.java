package com.ticketservice.user.domain.repository;

import com.ticketservice.user.domain.entity.UserUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author WangZeng
 * @Date 2021-04-10 16:15
 */
public interface UserRepo extends JpaRepository<UserUser,Long> {
    public UserUser queryByUsernameAndUserpw(String username,String userpw);

}
