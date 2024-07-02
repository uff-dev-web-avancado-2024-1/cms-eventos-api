package com.example.cmseventosapi.Auth.Exceptions;

public class UserMustBeAdminToPerformActionException extends RuntimeException{
    public UserMustBeAdminToPerformActionException(String message) {
        super(message);
    }
}
