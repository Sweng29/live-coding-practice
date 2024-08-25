package com.mapper.io;

public class InstanceOverFlowException extends RuntimeException {
    private String message;

    public InstanceOverFlowException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
