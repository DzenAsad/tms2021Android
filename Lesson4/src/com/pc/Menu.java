package com.pc;

import java.util.Scanner;

public class Menu {
    private boolean flag = true;
    private final Pc pc = new Pc();

    Menu() {
        outputMenu("Menu");
    }

    public void workMenu(String enteredNumber) {
        int selectedNum = Integer.parseInt(enteredNumber);
        Scanner scanner = new Scanner(System.in);

        if (selectedNum == 1) {
            outputMenu("Check");
            pc.ON(scanner.nextInt());
            outputMenu("Menu");
            return;
        }
        if (selectedNum == 2) {
            outputMenu("Check");
            pc.OFF(scanner.nextInt());
            outputMenu("Menu");
            return;
        }
        if (selectedNum == 0) {
            flag = false;
        }
    }

    private void outputMenu(String stringCase) {

        switch (stringCase) {
            case "Menu" -> {
                System.out.println(":Pc status work = " + pc.isStatusWork() + ":");
                System.out.println(":Menu PC:");
                System.out.println("1.PС ON");
                System.out.println("2.PС OFF");
                System.out.println("0.Exit");
            }
            case "Check" -> System.out.println("Input 0 or 1 to try command");
        }
    }

    public boolean isFlag() {
        return flag;
    }
}
