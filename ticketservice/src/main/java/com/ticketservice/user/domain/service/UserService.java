package com.ticketservice.user.domain.service;

import com.ticketservice.user.domain.entity.UserUser;
import com.ticketservice.user.domain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WangZeng
 * @Date 2021-04-10 16:14
 */
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public UserUser queryUsernameAndPassword(String username, String password){
        return userRepo.queryByUsernameAndUserpw(username,password);
    }

}
