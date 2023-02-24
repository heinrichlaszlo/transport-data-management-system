package com.transportdatamanagementsystem.exception;

public class InvalidUserPermissionException extends RuntimeException{
    public InvalidUserPermissionException(String message){
        super(message);
    }
}
