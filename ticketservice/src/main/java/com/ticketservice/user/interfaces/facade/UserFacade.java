package com.ticketservice.user.interfaces.facade;

import com.ticketservice.user.domain.entity.UserUser;
import com.ticketservice.user.domain.service.UserService;
import com.ticketservice.user.interfaces.dto.LoginCommand;
import com.ticketservice.user.interfaces.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangZeng
 * @Date 2021-04-10 15:31
 */
@RestController
@RequestMapping("/users")
public class UserFacade {
    @Autowired
    UserService userService;



    @PostMapping("/login")
    public ResultDTO<UserUser> login(@RequestBody LoginCommand loginCommand){
        String username = loginCommand.getUsername();
        String password = loginCommand.getPassword();
        System.out.println("username = " + username + ", password = " + password);
        UserUser user = userService.queryUsernameAndPassword(username,password);
        return ResultDTO.of(user);
    }

}
