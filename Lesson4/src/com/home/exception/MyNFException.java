package com.home.exception;

import java.io.IOException;

public class MyNFException extends NumberFormatException {
    public  MyNFException(Exception e) {
        super("Wrong input!");
        System.err.println("You entered text instead of number!");
    }
}
