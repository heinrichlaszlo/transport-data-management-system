package com.transportdatamanagementsystem.exception;

public class NoneUserPermissionException extends RuntimeException{
    public NoneUserPermissionException(String message){
        super(message);
    }
}
