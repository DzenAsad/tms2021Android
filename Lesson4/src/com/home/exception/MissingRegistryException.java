package com.home.exception;


public class MissingRegistryException extends NullPointerException {
    public MissingRegistryException() {
        System.err.println("Registry is Null");
    }
}

