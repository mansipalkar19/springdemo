package com.example.fullstackdemo.exception;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(Long id)
    {
        super("couldn't find user with id"+id);
    }
}
