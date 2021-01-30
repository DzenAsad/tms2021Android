package com.home;


import com.home.UI.MyReader;
import com.home.model.Address;
import com.home.model.Person;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RecruitingOffice {
    private Person[] recruits;

    public RecruitingOffice(Person[] recruits) {
        List<Person> tmpListPersons = new LinkedList<>();
        // Checking of requirements
        for (Person person : recruits) {
            if (person.getAge() < 27 && person.getAge() > 18 && person.getGender() == 'M') {
                tmpListPersons.add(person);
            }
        }
        // List to Array
        Person[] tmpArrPersons = new Person[tmpListPersons.size()];
        for (int i = 0; i < tmpArrPersons.length; i++) {
            tmpArrPersons[i] = tmpListPersons.get(i);
        }

        this.recruits = tmpArrPersons;
    }

    public int countPeople(Address address) {
        int count = 0;
        for (Person person : recruits) {
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
        for (Person person : recruits) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(country)) {
                count++;
            }
        }
        return count;
    }

    public List<Person> getPeople(Address address) {
        List<Person> people = new LinkedList<>();
        for (Person person : recruits) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(address.getCountry())
                    && personsAddress.getCity().equals(address.getCity())) {
                people.add(person);
            }
        }
        return people;
    }

    public void showPeople(Address address) {
        System.out.println("Recruited people");
        for (Person person : getPeople(address)) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getGender());
        }
    }

    public static void actionPersonRegistry(MyReader reader) throws IOException {
        System.out.println("-Please input String like: \"age name height gender country city\"-");
        RecruitingOffice recruitingOffice = new RecruitingOffice(Person.getArrayPersons(reader));
        System.out.println("-Please input String like: \"country city\"-");
        recruitingOffice.showPeople(Address.createAddress(reader.someRead().get(0)));
    }
}
