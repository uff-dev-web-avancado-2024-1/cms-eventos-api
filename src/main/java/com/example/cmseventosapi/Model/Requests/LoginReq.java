package com.example.cmseventosapi.Model.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {
    private String login;
    private String password;
}
