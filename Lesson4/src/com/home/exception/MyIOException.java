package com.home.exception;

import java.io.IOException;

public class MyIOException extends IOException {
    MyIOException(){
        super("Wrong input!");
        System.out.println("Wrong input!");
    }
}
