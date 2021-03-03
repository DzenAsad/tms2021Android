package com.examShop.exceptions;

public class WrongInitDataException extends NullPointerException{
    public WrongInitDataException(String errString) {
        System.err.print(" Wrong info \"" + errString + "\".");
    }
}
