package com.home.exception;

public class MyAIOOBException extends ArrayIndexOutOfBoundsException {
    public MyAIOOBException() {
        super("Wrong input! Need more data!");
        System.out.println("Wrong input! Need more data!");
    }
}
