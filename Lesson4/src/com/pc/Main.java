package com.pc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();


        while (menu.isFlag()) {
            menu.workMenu(scanner.next());
        }
    }
}
