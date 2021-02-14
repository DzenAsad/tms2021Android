package com.home.exception;

public class MyIOBExeption extends IndexOutOfBoundsException{
    MyIOBExeption(){
        super("Wrong input! Not all data!");
        System.out.println("Wrong input! Not all data!");
    }
}
