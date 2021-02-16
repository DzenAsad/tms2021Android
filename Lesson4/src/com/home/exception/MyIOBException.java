package com.home.exception;

public class MyIOBException extends IndexOutOfBoundsException {
    public MyIOBException() {
        super("Wrong input! Empty input!");
        System.out.println("Wrong input! Empty input!");
    }
}
