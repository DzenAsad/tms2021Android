package com.home.exception;

public class MyIOBExeption extends IndexOutOfBoundsException{
    public MyIOBExeption(){
        super("Wrong input! Empty input!");
        System.out.println("Wrong input! Empty input!");
    }
}
