package com.home.exception;


public class MissingAddressException extends NullPointerException {
    public  MissingAddressException() {
        System.err.println("Address is Null");
    }
}

