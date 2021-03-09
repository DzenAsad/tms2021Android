package com.examShop.exceptions;

public class MyShopException extends Exception {

    public static String messageFormat = "Error Occurred:\n  %s\n";

    public MyShopException() {
        super();
    }

    public MyShopException(String message) {
        super(String.format(messageFormat, message));
        System.err.printf(messageFormat, message);
    }
}
