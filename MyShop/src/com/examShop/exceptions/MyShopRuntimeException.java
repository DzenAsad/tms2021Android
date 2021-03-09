package com.examShop.exceptions;

public class MyShopRuntimeException extends RuntimeException {

    public static String messageFormat = "Critical Error Occurred:\n  %s";

    public MyShopRuntimeException() {
        super();
    }

    public MyShopRuntimeException(String message) {
        super(String.format(messageFormat, message));
        System.err.printf(messageFormat, message);
    }
}
