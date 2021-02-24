package com.Readers;


import java.io.IOException;
import java.util.List;

public interface MyReader {

    List<String> someRead() throws IOException;

    default String someReadToOneString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : someRead()) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
