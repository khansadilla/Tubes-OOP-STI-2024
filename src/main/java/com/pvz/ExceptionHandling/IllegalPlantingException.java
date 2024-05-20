package com.pvz.ExceptionHandling;

public class IllegalPlantingException extends Exception {
    String message;

    public IllegalPlantingException(String message) {
        super(message);
    }

    public String getMessage() {
        return String.format("Plant cannot be planted here", message);
    }
}