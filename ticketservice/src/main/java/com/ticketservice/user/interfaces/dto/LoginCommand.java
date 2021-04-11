package com.ticketservice.user.interfaces.dto;

import lombok.Data;

/**
 * @Author WangZeng
 * @Date 2021-04-11 3:37
 */
@Data
public class LoginCommand {
    private String username;
    private String password;
    public LoginCommand() {
    }

}
