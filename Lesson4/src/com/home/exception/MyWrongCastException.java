package com.home.exception;

public class MyWrongCastException extends IllegalArgumentException{
    public MyWrongCastException(){
        super("Wrong cast!");
    }
}
