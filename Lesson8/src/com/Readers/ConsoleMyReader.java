package com.Readers;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMyReader implements MyReader {
    public List<String> someRead() {
        System.out.println("-For exit put 0-");
        List<String> data = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("0")) {
            data.add(scanner.nextLine());
        }
        return data;
    }
}
