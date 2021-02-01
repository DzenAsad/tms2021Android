package com.home;

import com.home.UI.MyReader;
import com.home.model.Address;
import com.home.model.Fabric;
import com.home.model.Model;
import com.home.model.Person;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PersonRegistry implements Model {
    private Person[] citizens;

    public PersonRegistry(Person[] citizens) {
        this.citizens = citizens;
    }

    public int countPeople(Address address) {
        int count = 0;
        for (Person person : citizens) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(address.getCountry())
                    && personsAddress.getCity().equals(address.getCity())) {
                count++;
            }
        }
        return count;
    }

    public int countPeople(String country) {
        int count = 0;
        for (Person person : citizens) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(country)) {
                count++;
            }
        }
        return count;
    }

    public List<Person> getPeople(Address address) {
        List<Person> people = new LinkedList<>();
        for (Person person : citizens) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(address.getCountry())
                    && personsAddress.getCity().equals(address.getCity())) {
                people.add(person);
            }
        }
        return people;
    }

    public void showPeople(Address address) {
        System.out.println("Registered people");
        for (Person person : getPeople(address)) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
        }
    }


}
