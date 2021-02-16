package com.home.model;

import java.util.Objects;
import java.util.Random;

public class Person {
    private Address address;
    private char gender;
    private int age;
    private String name;
    private int height;

    public Person() {
    }

    public Person(int age, String name, int height, char gender) {
        this(age, name);
        this.height = height;
        this.gender = gender;
    }

    public Person(int age, String name) {
        this();
        this.height = 180;
        this.age = age;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender == person.gender && age == person.age && height == person.height && address.equals(person.address) && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, gender, age, name, height);
    }
}