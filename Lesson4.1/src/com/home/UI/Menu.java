package com.home.UI;

import com.home.PersonRegistry;
import com.home.RecruitingOffice;
import java.io.IOException;



public class Menu {
    private int submenu = 0;
    private boolean flag = true;

    public Menu(){
        outputMenu("Start");
    }

    //Menu logic
    public void workMenu(String num) throws IOException {
        int selectedNum = Integer.parseInt(num);

        //Main menu
        if (submenu == 0) {
            if (selectedNum == 1) { submenu = 1; outputMenu("readConsole");return; }
            if (selectedNum == 2) { submenu = 2; outputMenu("readFile");return; }
            if (selectedNum == 0) { flag = false;return; }
        }

        //Console reader activated
        if (submenu == 1) {
            MyReader myReader = new ConsoleMyReader();

            if (selectedNum == 1) {
                RecruitingOffice.actionPersonRegistry(myReader);
                submenu = 0;outputMenu("Start");return; }
            if (selectedNum == 2) {
                PersonRegistry.actionPersonRegistry(myReader);
                submenu = 0;outputMenu("Start");return;}
            if (selectedNum == 0) { submenu = 0;outputMenu("Start");return; }
        }

        //File reader activated
        if (submenu == 2) {
            MyReader myReader = new FileMyReader(); //C:\Users\User\IdeaProjects\tms2021Android\Lesson4.1\src\com\home\data\Persons.txt

            if (selectedNum == 1) {
                RecruitingOffice.actionPersonRegistry(myReader);
                submenu = 0;outputMenu("Start");return; }
            if (selectedNum == 2) {
                PersonRegistry.actionPersonRegistry(myReader);
                submenu = 0;outputMenu("Start");return;}
            if (selectedNum == 0) { submenu = 0;outputMenu("Start");return; }
        }
    }


    private void outputMenu(String stringCase) {

        switch (stringCase) {
            case "readConsole" -> {
                System.out.println(":Read from console Menu:");
                System.out.println("1.RecruitingOffice");
                System.out.println("2.PersonRegistry");
                System.out.println("0.Back");
            }
            case "readFile" -> {
                System.out.println(":Read from file Menu:");
                System.out.println("1.RecruitingOffice");
                System.out.println("2.PersonRegistry");
                System.out.println("0.Back");
            }
            case "Start" -> {
                System.out.println(":Main menu:");
                System.out.println("1.Console");
                System.out.println("2.File");
                System.out.println("0.Exit");
            }
        }
    }

    public boolean isFlag() {
        return flag;
    }


}
