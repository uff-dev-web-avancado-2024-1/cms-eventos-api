package com.example.cmseventosapi.Model.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterReq {
    private String name;
    private String email;
    private String login;
    private String password;
}
