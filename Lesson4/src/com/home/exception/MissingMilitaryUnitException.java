package com.home.exception;


public class MissingMilitaryUnitException extends NullPointerException {
    public MissingMilitaryUnitException() {
        System.err.println("MilitaryUnit is Null");
    }
}

