package com.home.UI;

import com.home.PersonRegistry;
import com.home.RecruitingOffice;
import com.home.model.Address;
import com.home.model.Fabric;
import com.home.model.Person;

import java.io.IOException;


public class Menu {
    private int submenu = 0;
    private boolean flag = true;
    private PersonRegistry personRegistry = null;
    private Address address = null;

    public Menu() {
        outputMenu("Start");
    }

    //Menu logic
    public void workMenu(String enteredNumber) throws IOException {
        int selectedNum = Integer.parseInt(enteredNumber);
        Fabric fabric = new Fabric();


        //Main menu
        if (submenu == 0) {
            MyReader myReader = new ConsoleMyReader();
            if (selectedNum == 1) {
                submenu = 1;
                outputMenu("readConsole");
                return;
            }
            if (selectedNum == 2) {
                submenu = 2;
                outputMenu("readFile");
                return;
            }
            if (selectedNum == 3) {
                submenu = 0;
                outputMenu("showStatusInfo");
                outputMenu("Start");
                return;
            }
            if (selectedNum == 4 && address != null && personRegistry != null) {
                RecruitingOffice recruitingOffice = (RecruitingOffice) fabric.getModelRecruitingOffice(personRegistry, myReader);
                System.out.println("Recruited people");
                //Cycle get List<Persons> and show info
                for (Person person : recruitingOffice.getPeople(address)) {
                    System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
                }
                recruitingOffice.loadUnits(address); //load units
                submenu = 0;
                outputMenu("Start");
                return;
            } else {
                System.out.println("You need initialize Address and PersonRegistry first!");
            }
            if (selectedNum == 0) {
                flag = false;
                return;
            }
        }

        //Console reader activated
        if (submenu == 1) {
            MyReader myReader = new ConsoleMyReader();

            if (selectedNum == 1) {
                personRegistry = (PersonRegistry) fabric.getModel("PersonRegistry", myReader);
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 2) {
                address = (Address) fabric.getModel("Address", myReader);
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 0) {
                submenu = 0;
                outputMenu("Start");
                return;
            }
        }

        //File reader activated
        if (submenu == 2) {
            MyReader myReader = new FileMyReader(); //C:\Users\User\IdeaProjects\tms2021Android\Lesson4.1\src\com\home\data\Persons.txt


            if (selectedNum == 1) {
                personRegistry = (PersonRegistry) fabric.getModel("PersonRegistry", myReader);
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 2) {
                address = (Address) fabric.getModel("Address", myReader);
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 0) {
                submenu = 0;
                outputMenu("Start");
                return;
            }
        }

    }


    private void outputMenu(String stringCase) {

        switch (stringCase) {
            case "readConsole" -> {
                System.out.println(":Read from console Menu:");
                System.out.println("1.PersonRegistry");
                System.out.println("2.Address");
                System.out.println("0.Back");
            }
            case "readFile" -> {
                System.out.println(":Read from file Menu:");
                System.out.println("1.PersonRegistry");
                System.out.println("2.Address");
                System.out.println("0.Back");
            }
            case "Start" -> {
                System.out.println(":Main menu:");
                System.out.println("1.Console");
                System.out.println("2.File");
                System.out.println("3.Show initialized things");
                System.out.println("4.RecruitingOffice");
                System.out.println("0.Exit");
            }
            case "showStatusInfo" -> {
                if (personRegistry != null) {
                    System.out.println("PersonRegistry initialized");
                } else {
                    System.out.println("PersonRegistry NOT initialized");
                }

                if (address != null) {
                    System.out.println("Address initialized");
                } else {
                    System.out.println("Address NOT initialized");
                }

            }
        }
    }


    public boolean isFlag() {
        return flag;
    }


}
