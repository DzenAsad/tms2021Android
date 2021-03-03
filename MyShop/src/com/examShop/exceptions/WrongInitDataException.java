package com.examShop.exceptions;

public class WrongInitDataException extends NullPointerException{
    public WrongInitDataException(String errString) {
        System.err.print("Exception: Wrong info \"" + errString + "\".");
    }
}
