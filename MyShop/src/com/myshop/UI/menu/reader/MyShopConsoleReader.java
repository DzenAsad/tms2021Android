package com.myshop.UI.menu.reader;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyShopConsoleReader implements MyShopReader {
    public List<String> someRead() {
        System.out.println("-For exit put 0-");
        List<String> data = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("0")) {
            String tmp = scanner.nextLine();
            data.add(tmp);
        }
        return data;
    }
}
