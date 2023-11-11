package com.arieltintel.oauth.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Nome de Usuario ou Senha incorreto");
    }

}
