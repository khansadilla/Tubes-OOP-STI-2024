package com.pvz.ExceptionHandling;

public class CooldownException extends Exception{
    String message;

    public CooldownException(String message){
        super(message);
    }

    public String getMessage(){
        return String.format("Plant is on cooldown", message);
    }
}
