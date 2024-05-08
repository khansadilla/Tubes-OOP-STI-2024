package com.pvz.ExceptionHandling;

public class IllegalTypeException extends java.lang.Exception {
    String message;

    public IllegalTypeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("Type not found.", message);
    }
}
