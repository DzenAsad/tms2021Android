package com.home.exception;

import java.io.IOException;

public class MyNPE extends NullPointerException {
    public  MyNPE(String string) {
        System.err.println(string + " is Null");
    }
}
