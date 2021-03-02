package com.examShop.exceptions.Product;

public class NullProductException extends NullPointerException{
    public NullProductException(String errString){
        System.err.print("Wrong info \"" + errString + "\" ");
    }
}
