package com.home.UI;

import com.home.exception.MissingAddressException;
import com.home.model.PersonRegistry;
import com.home.model.RecruitingOffice;
import com.home.UI.Readers.ConsoleMyReader;
import com.home.UI.Readers.FileMyReader;
import com.home.UI.Readers.MyReader;
import com.home.model.Address;
import com.home.model.Person;
import com.home.model.fabric.FabricControl;
import com.home.model.fabric.RecruitingOffice.RecruitingOfficeFabric;

import java.io.IOException;
import java.util.List;


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
        FabricControl fabricControl = new FabricControl();


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
                outputMenu("showStatusInfo");
                outputMenu("Start");
                return;
            }
            if (selectedNum == 4) {
                //Read from console to list
                System.out.println("-Please input String like: \"unit_range name\"-");
                List<String> inputData = myReader.someRead();
                //Init RecruitingOffice
                RecruitingOffice recruitingOffice = ((RecruitingOfficeFabric) fabricControl.getNeedFabric(RecruitingOffice.class)).setPersonRegistry(personRegistry).getSomeObject(inputData);
                try {
                    //Check address not null
                    if (address == null) {
                        throw new MissingAddressException();
                    } else {
                        //Cycle get List<Persons> and show info
                        System.out.println("Recruited people");
                        for (Person person : recruitingOffice.getPeople(address)) {
                            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());
                        }
                        //load units
                        recruitingOffice.loadUnits(address);
                    }
                } catch (MissingAddressException e) {
                    System.err.println("Can't execute");
                }
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 0) {
                flag = false;
                return;
            }
        }

        //Console reader activated Menu
        if (submenu == 1) {
            MyReader myReader = new ConsoleMyReader();

            if (selectedNum == 1) {
                //Read from console to list
                System.out.println("-Please input String like: \"age name height gender country city\"-");
                List<String> inputData = myReader.someRead();
                //PersonRegistry(Person[])
                personRegistry = new PersonRegistry(fabricControl.getNeedFabric(Person[].class).getSomeObject(inputData));
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 2) {
                System.out.println("-Please input String like: \"country city\"-");
                List<String> inputData = myReader.someRead(); //Read from console to list
                address = fabricControl.getNeedFabric(Address.class).getSomeObject(inputData);
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

        //File reader activated Menu
        if (submenu == 2) {
            MyReader myReader = new FileMyReader(); //C:\Users\User\IdeaProjects\tms2021Android\Lesson4\src\com\home\data\Persons.txt


            if (selectedNum == 1) {
                //Read from console to list
                System.out.println("-Please input String like: \"age name height gender country city\"-");
                List<String> inputData = myReader.someRead();
                //PersonRegistry(Person[])
                personRegistry = new PersonRegistry(fabricControl.getNeedFabric(Person[].class).getSomeObject(inputData));
                submenu = 0;
                outputMenu("Start");
                return;
            }
            if (selectedNum == 2) {
                //Read from console to list
                System.out.println("-Please input String like: \"country city\"-");
                List<String> inputData = myReader.someRead();
                address = fabricControl.getNeedFabric(Address.class).getSomeObject(inputData);
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
