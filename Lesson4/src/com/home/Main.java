package com.home;

import com.home.UI.Menu;
import com.home.model.Address;
import com.home.model.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
//        Person konstantin = new Person(30, "Konstantin");
//        Address konstantinsAddress = new Address("Belarus", "Vitebsk");
//        konstantin.setAddress(konstantinsAddress);
////        konstantin.info();
//
//        Person gleb = new Person(40, "Gleb", 190);
//        Address glebsAddress = new Address("Belarus", "Vitebsk");
//        gleb.setAddress(glebsAddress);
////        gleb.info();
//
//        Person oleg = new Person(38, "Oleg", 189);
//        Address olegsAddress = new Address("Belarus", "Braslav");
//        oleg.setAddress(olegsAddress);
//
//        Person vadim = new Person(30, "Vadim", 180);
//        Address vadimsAddress = new Address("Belarus", "Smorgon'");
//        vadim.setAddress(vadimsAddress);
//
//        PersonRegistry registry = new PersonRegistry(new Person[]{gleb, konstantin, oleg, vadim});
//
//        System.out.println(registry.countPeople(new Address("Belarus", "Vitebsk")));
//        System.out.println(registry.countPeople(new Address("Belarus", "Krarow")));
//        System.out.println(registry.countPeople("Belarus"));
//
//
//        List<Person> personList = registry.getPeople(new Address("Belarus", "Vitebsk"));
//        for (Person person : personList) {
//            System.out.println(person.getName());
//        }




        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();


        while (menu.isFlag()) {
            menu.workMenu(scanner.next());
        }


    }




}

