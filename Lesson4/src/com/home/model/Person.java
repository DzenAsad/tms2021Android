package com.home.model;

import java.util.Objects;
import java.util.Random;

public class Person {
    private Address address;
    private char gender;
    private int age;
    private String name;
    private String surname;
    private int height;

    public Person() {
    }

    public Person(int age, String name, String surname, int height, char gender) {
        this(age, name);
        this.height = height;
        this.gender = gender;
        this.surname = surname.trim().toLowerCase().replaceFirst("^\\w", surname.substring(0, 1).toUpperCase());
    }

    public Person(int age, String name) {
        this();
        this.height = 180;
        this.age = age;
        this.name = name.trim().toLowerCase().replaceFirst("^\\w", name.substring(0, 1).toUpperCase());
        this.gender = 'n';

    }

    public void info() {
        Random random = new Random();
        if (random.nextInt(40) < 20) {
            System.out.println("Hello, my name is " + name);
        } else {
            secureInfo();
        }
        System.out.println("I am living in " + address.toString());
    }

    private void secureInfo() {
        System.out.println("Hello, my name is " + name + " and I'm " + age + " years old");
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(age, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender == person.gender && age == person.age && height == person.height && Objects.equals(address, person.address) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, gender, age, name, surname, height);
    }
}